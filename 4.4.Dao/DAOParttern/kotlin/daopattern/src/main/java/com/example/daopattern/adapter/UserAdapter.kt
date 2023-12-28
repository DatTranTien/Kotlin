package com.example.daopattern.adapter

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.daopattern.MainActivity
import com.example.daopattern.MainActivity2
import com.example.daopattern.R
import com.example.daopattern.data.User

class UserAdapter(private val context: Context,private val dataSet: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View,listener: MainActivity.OptionMenuClickListener) : RecyclerView.ViewHolder(itemView) {
//        init {
//            this.listener = listener
//        }
//
        val usernameTextView: TextView = itemView.findViewById(R.id.usernameTextView)
        val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
        val showOptionsButton: ImageView = itemView.findViewById(R.id.img_option)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = dataSet[position]
        holder.usernameTextView.text = user.name
        holder.emailTextView.text = user.email
        holder.showOptionsButton.setOnClickListener { view ->
            showPopupMenu(view, user,listener)
        }
    }

//    private fun showPopupMenu(view: View?, item: User) {
//
//    }

    private fun showPopupMenu(view: View, item:User,listener:MainActivity.OptionMenuClickListener) {
        val popupMenu = PopupMenu(context, view)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.options_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.delete -> {
                    listener.delete(menuItem.itemId)
                    // Xử lý khi chọn Option 1
                    true
                }
                R.id.update -> {
                    listener.update(menuItem.itemId)
//                    val intent = Intent(this.context, MainActivity2::class.java)
//                    startActivity(intent)
                    // Xử lý khi chọn Option 2
                    true
                }
                // Xử lý cho các tùy chọn khác nếu cần
                else -> false
            }
        }

        popupMenu.show()
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
