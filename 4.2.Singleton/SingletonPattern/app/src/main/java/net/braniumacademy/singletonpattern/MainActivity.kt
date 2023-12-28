package net.braniumacademy.singletonpattern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = UserViewModel.getInstance()
        val textInfo: TextView = findViewById(R.id.text_user_info)

        val btnStart = findViewById<Button>(R.id.btn_start_activity)
        btnStart.setOnClickListener {
            Intent(this, OtherActivity::class.java).apply {
                startActivity(this)
            }
        }

        viewModel.user.observe(this) {
            val message = "Full name: ${it.fullName}"
            textInfo.text = message
        }

        Log.e("MainActivity ==> ", "${viewModel.hashCode()}")
    }
}