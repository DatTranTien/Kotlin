package net.braniumacademy.kotlin.ui.newuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.braniumacademy.kotlin.databinding.ActivityNewUserBinding
import net.braniumacademy.kotlin.ui.viewmodel.UserViewModel

class NewUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNewUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCancel.setOnClickListener { finish() }
        binding.btnAdd.setOnClickListener {
            val viewModel = UserViewModel.getInstance()
            val name = binding.editName.text.toString()
            val email = binding.editEmail.text.toString()
            viewModel.addNewUser(name, email)
            finish()
        }
    }
}