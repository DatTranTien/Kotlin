package net.braniumacademy.kotlin.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.braniumacademy.kotlin.databinding.ActivityUserDetailBinding
import net.braniumacademy.kotlin.ui.viewmodel.UserViewModel

class UserDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fillData()
        setAction()
    }

    private fun fillData() {
        val userId = intent.getIntExtra(EXTRA_ID, 0)
        val user = UserViewModel.getInstance().getUser(userId)
        binding.editEmailDetail.setText(user?.email)
        binding.editNameDetail.setText(user?.name)
    }

    private fun setAction() {
        binding.btnOk.setOnClickListener { finish() }
    }

    companion object {
        const val EXTRA_ID = "net.braniumacademy.kotlin.ui.detail.EXTRA_ID"
    }
}