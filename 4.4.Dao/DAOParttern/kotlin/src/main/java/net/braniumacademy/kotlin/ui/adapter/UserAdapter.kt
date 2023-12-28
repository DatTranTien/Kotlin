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
) : RecyclerView.Adapter<ViewHolder>() {
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
        holder.updateIndex(position)
    }
}

