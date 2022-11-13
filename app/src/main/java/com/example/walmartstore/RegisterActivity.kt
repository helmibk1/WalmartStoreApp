package com.example.walmartstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    lateinit var newUser: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val firstNameEditBox = findViewById<TextInputEditText>(R.id.first_name_editbox)
        val lastNameEditBox = findViewById<TextInputEditText>(R.id.last_name_editbox)
        val emailEditBox = findViewById<TextInputEditText>(R.id.email_editbox)
        val passwordEditBox = findViewById<TextInputEditText>(R.id.password_editbox)
        val createAccountButton = findViewById<Button>(R.id.create_account_button)


        createAccountButton.setOnClickListener {
            newUser = User(firstNameEditBox.text.toString(),lastNameEditBox.text.toString(), userName = User.UserName(
                emailEditBox.text.toString(),
                passwordEditBox.text.toString()
            ))
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("UserName", newUser.userName?.email)
            intent.putExtra("newUserOnject", newUser)
            startActivity(intent)

        }
    }
}