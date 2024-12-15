package com.example.restaurantapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity // This is required

class MenuActivity : AppCompatActivity() { // Extend AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu) // Ensure this layout file exists
    }
}
