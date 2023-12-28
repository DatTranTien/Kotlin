package com.example.a43observer

class Object1(private val name:String): ObserverTest {
    override fun update(text: String) {
        println("Object 1--->"+name+"---"+text)
    }
}
