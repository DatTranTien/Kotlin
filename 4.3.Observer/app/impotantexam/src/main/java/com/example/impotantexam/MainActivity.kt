package com.example.impotantexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button1=findViewById<Button>(R.id.button1)
        var textShow=findViewById<TextView>(R.id.textView)
        var vm=MainViewModel.getInstance()
        vm.data.observe(this){
            textShow.text=it!!
        }

        button1.setOnClickListener {
            Intent(this@MainActivity, AddNameActivity::class.java).apply {
                startActivity(this)
            }


        }
    }
}