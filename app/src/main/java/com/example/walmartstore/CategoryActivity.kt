package com.example.walmartstore

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CategoryActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        val userName = findViewById<TextView>(R.id.userName)
        val electronicsLinearLayout = findViewById<LinearLayout>(R.id.electronics_linearLayout)
        val clothLinearLayout = findViewById<LinearLayout>(R.id.cloth_linearLayout)
        val beautyLinearLayout = findViewById<LinearLayout>(R.id.beauty_linearLayout)
        val foodLinearLayout = findViewById<LinearLayout>(R.id.food_linearLayout)
        val extras = intent.extras
        var userNameText = ""
        extras?.let {
            userNameText = extras.getString("UserName")?:""
        }

        userName.text = userNameText

        electronicsLinearLayout.setOnClickListener {
            Toast.makeText(this, "You have chosen the Electronics category of shopping", Toast.LENGTH_SHORT).show()
        }
        clothLinearLayout.setOnClickListener {
            Toast.makeText(this, "You have chosen the Cloth category of shopping", Toast.LENGTH_SHORT).show()
        }
        beautyLinearLayout.setOnClickListener {
            Toast.makeText(this, "You have chosen the Beauty category of shopping", Toast.LENGTH_SHORT).show()
        }
        foodLinearLayout.setOnClickListener {
            Toast.makeText(this, "You have chosen the Food category of shopping", Toast.LENGTH_SHORT).show()
        }
    }
}