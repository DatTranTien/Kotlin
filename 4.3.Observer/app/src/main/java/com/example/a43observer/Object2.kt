package com.example.a43observer

class Object2(private val name:String):ObserverTest {
    private var name1: String? = null
    fun Object2(name: String) {
        name1 = name
    }
    override fun update(text: String) {
        println("Object 2--->"+name+"---"+text)
    }
}