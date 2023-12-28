package net.braniumacademy.kotlin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.braniumacademy.kotlin.dao.UserDAO
import net.braniumacademy.kotlin.data.User

class UserViewModel private constructor() : ViewModel() {
    private val _users: MutableLiveData<List<User>> = MutableLiveData()
    private val userDao = UserDAO.getInstance()
    val users: LiveData<List<User>> = _users

    init {
        _users.value = userDao.getAll()
    }

    fun addNewUser(name: String, email: String) {
        userDao.save(User(name, email))
        _users.value = userDao.getAll()
    }

    fun removeUser(index: Int) {
        val user = userDao.get(index)
        userDao.delete(user!!)
        _users.value = userDao.getAll()
    }

    fun updateUser(index: Int, name: String, email: String) {
        val user = userDao.get(index)
        userDao.update(user!!, arrayOf(name, email))
        _users.value = userDao.getAll()
    }

    companion object {
        private val viewModel = UserViewModel()

        fun getInstance(): UserViewModel {
            return viewModel
        }
    }
}