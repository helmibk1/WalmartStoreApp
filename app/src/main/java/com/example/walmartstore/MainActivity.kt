package com.example.walmartstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    var users = arrayListOf(
        User("test1","test11", User.UserName("test", "test")),
        User("test1","test11", User.UserName("test1@gmail.com", "test1")),
        User("test2","test22", User.UserName("test2@gmail.com", "test2")),
        User("test3","test33", User.UserName("test3@gmail.com", "test3")),
        User("test4","test44", User.UserName("test4@gmail.com", "test4")),
        User("test5","test55", User.UserName("test5@gmail.com", "test5"))
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userEmail = findViewById<TextInputEditText>(R.id.emailEditText)
        val userPassword = findViewById<TextInputEditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.sign_in_button)
        val createAccountButton = findViewById<Button>(R.id.create_account_button)

        intent?.let {
            val newUser =  intent.extras?.getParcelable("newUserOnject") as User?
            newUser?.let {
                users.add(it)
            }
        }






        loginButton.setOnClickListener {
            val loginInstance = User(userName = User.UserName(userEmail.text.toString(),userPassword.text.toString()))
            if (loginInstance.userName?.email?.isBlank() ?: false || loginInstance.userName?.password?.isBlank() ?: false){
                Toast.makeText(applicationContext, "Empty fields!",Toast.LENGTH_SHORT).show()
            }else if(!users.map { u -> u.userName }.contains(loginInstance.userName)){
                Toast.makeText(applicationContext, "User not found",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this@MainActivity, CategoryActivity::class.java)

                intent.putExtra("UserName", userEmail.text.toString())

                startActivity(intent)
            }
        }

        createAccountButton.setOnClickListener {
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}