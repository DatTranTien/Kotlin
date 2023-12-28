package net.braniumacademy.kotlin.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import net.braniumacademy.kotlin.ui.MainActivity
import net.braniumacademy.kotlin.R
import net.braniumacademy.kotlin.data.User
import net.braniumacademy.kotlin.databinding.UserItemBinding

class UserAdapter(
    private val users: List<User>,
    private val listener: MainActivity.OptionMenuClickListener
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(
        view: View,
        binding: UserItemBinding,
        private val listener: MainActivity.OptionMenuClickListener
    ) : RecyclerView.ViewHolder(view) {
        private val binding: UserItemBinding
        private lateinit var user: User

        init {
            this.binding = binding
            this.binding.imgOption.setOnClickListener { onOptionMenuClick() }
        }

        fun bindData(user: User) {
            this.user = user
            binding.textName.text = user.name
            binding.textEmail.text = user.email
        }

        private fun onOptionMenuClick() {
            val popup = PopupMenu(binding.root.context, binding.imgOption)
            popup.inflate(R.menu.option_menu)
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_item_delete -> {
                        listener.delete(user)
                        true
                    }

                    R.id.menu_item_update -> {
                        listener.update(user)
                        true
                    }

                    R.id.menu_item_detail -> {
                        listener.viewDetail(user)
                        true
                    }

                    else -> false
                }
            }
            popup.show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = UserItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding.root, binding, listener)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(users[position])
    }
}