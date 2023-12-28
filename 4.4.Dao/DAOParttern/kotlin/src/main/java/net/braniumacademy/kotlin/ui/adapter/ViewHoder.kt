package net.braniumacademy.kotlin.ui.adapter

import android.view.View
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import net.braniumacademy.kotlin.R
import net.braniumacademy.kotlin.data.User
import net.braniumacademy.kotlin.databinding.UserItemBinding
import net.braniumacademy.kotlin.ui.MainActivity

class ViewHolder(
    view: View,
    binding: UserItemBinding,
    listener: MainActivity.OptionMenuClickListener
) : RecyclerView.ViewHolder(view) {
    private val binding: UserItemBinding
    private var index: Int = 0
    private val listener: MainActivity.OptionMenuClickListener

    init {
        this.binding = binding
        this.binding.imgOption.setOnClickListener { onOptionMenuClick() }
        this.listener = listener
    }

    fun bindData(user: User) {
        binding.textName.text = user.name
        binding.textEmail.text = user.email
    }

    fun updateIndex(index: Int) {
        this.index = index
    }

    private fun onOptionMenuClick() {
        val popup = PopupMenu(binding.root.context, binding.imgOption)
        popup.inflate(R.menu.option_menu)
        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_item_delete -> {
                    listener.delete(index)
                    true
                }

                R.id.menu_item_update -> {
                    listener.update(index)
                    true
                }

                else -> false
            }
        }
        popup.show()
    }
}
