package com.example.daopattern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.daopattern.adapter.UserAdapter
import com.example.daopattern.data.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView: RecyclerView = findViewById(R.id.rc)
        val userList = createSampleUserList() // Hàm tạo danh sách người dùng mẫu
        val userAdapter = UserAdapter(this, userList)

        recyclerView.adapter = userAdapter
    }

    private fun createSampleUserList(): List<User> {
        // Hàm tạo danh sách người dùng mẫu
        val userList = mutableListOf<User>()
        userList.add(User("John Doe", "john@example.com"))
        userList.add(User("Jane Doe", "jane@example.com"))
        // Thêm các người dùng khác nếu cần
        return userList
    }
    interface OptionMenuClickListener {
        fun update(index: Int)
        fun delete(index: Int)
    }

//    fun update(index: Int) {
//        Intent(this, MainActivity2::class.java).apply {
//            startActivity(this)
//        }
//
//        interface OptionMenuClickListener {
//            fun update(index: Int)
//
//            //        {
////            val intent = Intent(this, MainActivity2::class.java)
////            startActivity(intent)
////        }
//            fun delete(index: Int)
//        }
//
//
//    }
}