package com.example.basicroomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.basicroomapp.database.User


class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.saveUser(
            User(
            "Userid0002" +
                    "",
                "name0002",
                1.71,
                71.1,
                "user002@gamil.com",
                "passworduser0002"
        )
        )

        mainViewModel.getUsers()
        //si es fragment
        //es con viewLifecycleOwner en lugar de this

        mainViewModel.savedUsers.observe(this, {usersList ->
            if(usersList.isNotEmpty()){
                for(user in usersList) {
                    Log.e("Estos son lo susuarios", user.user_name)
                }
            }else{
                Log.e("Estos son los usuarios", "null or empty")
            }
        })
    }
}