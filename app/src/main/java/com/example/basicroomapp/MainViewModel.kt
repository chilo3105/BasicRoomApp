package com.example.basicroomapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicroomapp.database.DatabaseManager
import com.example.basicroomapp.database.MyCoroutines
import com.example.basicroomapp.database.User
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val savedUsers = MutableLiveData<List<User>>()

    fun saveUser(user: User){
        viewModelScope.launch{
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines(userDao).save(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch{
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines(userDao).delete(user)
        }
    }

    fun getUsers(){
        viewModelScope.launch{
            val userDao = DatabaseManager.instance.database.userDao()
            savedUsers.value = MyCoroutines(userDao).getUsers().value
        }
    }

}