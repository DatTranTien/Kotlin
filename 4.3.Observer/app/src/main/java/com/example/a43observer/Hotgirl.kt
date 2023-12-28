package com.example.a43observer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class HotGirl {
    private var videoTitle: String? = null
    private val registers: MutableList<ObserverTest>

    init {
        registers = ArrayList()
    }

    fun register(register: ObserverTest) {
        registers.add(register)
    }

    fun unRegister(register: ObserverTest) {
        registers.remove(register)
    }
    fun showRegis(){
        println("Show----->"+registers)
    }


    /**
     * Phương thức gửi thông báo có video mới đăng đến những fan hâm mộ của hotgirl
     */
    private fun notice() {
        for (register in registers) {
            videoTitle?.let { register.update(it) }
        }
        println("==========================================")
    }

    fun postVideo(title: String?) {
        videoTitle = title
        notice()
    }
}
