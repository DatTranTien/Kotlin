package net.braniumacademy.kotlin.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import net.braniumacademy.kotlin.R
import net.braniumacademy.kotlin.ui.adapter.UserAdapter
import net.braniumacademy.kotlin.databinding.ActivityMainBinding
import net.braniumacademy.kotlin.ui.dialog.ConfirmationDialogFragment
import net.braniumacademy.kotlin.ui.newuser.NewUserActivity
import net.braniumacademy.kotlin.ui.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel

    @SuppressLint("UseCompatLoadingForDrawables", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = UserViewModel.getInstance()
        binding.recyclerUser.adapter = UserAdapter(viewModel.users.value!!,
            object : OptionMenuClickListener {
                override fun update(index: Int) {
                    ConfirmationDialogFragment(Action.UPPDATE, index).show(
                        supportFragmentManager,
                        "TAG"
                    )
                }

                override fun delete(index: Int) {
                    ConfirmationDialogFragment(Action.DELETE, index).show(
                        supportFragmentManager,
                        "TAG"
                    )
                }
            })
        viewModel.users.observe(this) {
            binding.recyclerUser.adapter?.notifyDataSetChanged()
        }
        binding.recyclerUser.layoutManager = LinearLayoutManager(this)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        getDrawable(R.drawable.divider)?.let { itemDecoration.setDrawable(it) }
        binding.recyclerUser.addItemDecoration(itemDecoration)
        binding.fbtnAdd.setOnClickListener {
            Intent(this, NewUserActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    interface OptionMenuClickListener {
        fun update(index: Int)
        fun delete(index: Int)
    }
}