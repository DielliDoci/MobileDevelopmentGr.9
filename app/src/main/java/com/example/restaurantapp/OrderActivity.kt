package com.example.restaurantapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity // Ensure this is imported

class OrderActivity : AppCompatActivity() { // Extend AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order) // Ensure this layout file exists

        val orderButton = findViewById<Button>(R.id.orderButton)
        orderButton.isSelected = true // Mark the button as selected

    }
}
