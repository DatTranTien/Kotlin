package com.example.a43observer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//Sub,UnSub, Observer,... thay đổi là ở Thằng Cha
// những thằng Object con khác Kế thừa lớp trung gian Observer để update
// Khi thằng cha đăng 1 video, các thằng con sẽ nhận được thông báo! (Vòng lặp-> gọi update trong Observer->cập nhật các thằng con)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var girl= HotGirl()
        var student1=Object1("Dat1")
        var student2=Object2("Dat2")
        var student3=Object3("Dat3")
        girl.register(student1)
        girl.register(student2)
        girl.register(student3)
        girl.showRegis()
        girl.postVideo("Em dep hong?")
        girl.unRegister(student2)
        girl.postVideo("Vai Ca Chuong thang so 2 UnScribe tao!")
    }
}