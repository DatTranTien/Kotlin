package net.braniumacademy.singletonpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        val viewModel: UserViewModel = UserViewModel.getInstance()
        val textUserInfo2: TextView = findViewById(R.id.text_user_info2)
        val editId = findViewById<EditText>(R.id.edit_user_id)
        val editFullName = findViewById<EditText>(R.id.edit_user_full_name)
        val editEmail = findViewById<EditText>(R.id.edit_user_email)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)
        btnSubmit.setOnClickListener {
            val id = editId.text.toString()
            val fullName = editFullName.text.toString()
            val email = editEmail.text.toString()
            val user = User(id, fullName, email)
            viewModel.updateUser(user)
            onBackPressedDispatcher.onBackPressed()
        }

        viewModel.user.observe(this) {
            val message = "Full name: ${it.fullName}"
            textUserInfo2.text = message
        }

        Log.e("OtherActivity ==> ", "${viewModel.hashCode()}")
    }
}