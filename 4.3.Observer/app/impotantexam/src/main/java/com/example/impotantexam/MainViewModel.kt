package com.example.impotantexam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel private constructor() {
    private val _data = MutableLiveData<String>()
     val data: LiveData<String> = _data
    fun update(name: String){
                _data.postValue(name)
            }
    companion object{
        private var instance:MainViewModel? = null
        fun getInstance():MainViewModel{
            if (instance==null){
                instance =MainViewModel()
            }
            return instance as MainViewModel
        }
    }
}