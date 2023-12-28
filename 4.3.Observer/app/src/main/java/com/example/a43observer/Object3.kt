package com.example.a43observer

class Object3(private val name:String): ObserverTest {
    private var name1: String? = null
    fun Object3(name: String) {
        name1 = name
    }
    override fun update(text: String) {
        println("Object 3--->"+name+"---"+text)
    }
}