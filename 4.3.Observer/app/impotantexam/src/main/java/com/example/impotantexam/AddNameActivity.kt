package com.example.impotantexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedDispatcher

class AddNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_name)

        var buttonAdd=findViewById<Button>(R.id.add)
        var input=findViewById<TextView>(R.id.inputName)
        var vm=MainViewModel.getInstance()

        buttonAdd.setOnClickListener{
            vm.update(input.text.toString())
            onBackPressedDispatcher.onBackPressed()
        }
    }
}