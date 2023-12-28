package net.braniumacademy.singletonpattern

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel private constructor() : ViewModel() {
    private var _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    init {
        _user.value = User("U100", "Le Thanh Cong", "thanhcong@xmail.com")
    }

    fun updateUser(user: User) {
        _user.value = user
    }

    companion object {
        private var instance: UserViewModel? = null

        fun getInstance(): UserViewModel {
            if (instance == null) {
                instance = UserViewModel()
            }
            return instance!!
        }
    }
}