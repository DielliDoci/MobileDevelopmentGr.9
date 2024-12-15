package com.example.restaurantapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Navigation buttons
        val homeButton = findViewById<Button>(R.id.homeButton)
        val menuButton = findViewById<Button>(R.id.menuButton)
        val orderButton = findViewById<Button>(R.id.orderButton)
        val profileButton = findViewById<Button>(R.id.profileButton)

        // Set click listeners for navigation
        homeButton.setOnClickListener {
            // Stay on the current activity (or reload home content)
        }

        menuButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        orderButton.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }

        profileButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}
