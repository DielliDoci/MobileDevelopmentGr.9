package com.example.restaurantapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity // Ensure this is imported

class OrderActivity : AppCompatActivity() { // Extend AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order) // Ensure this layout file exists
    }
}
