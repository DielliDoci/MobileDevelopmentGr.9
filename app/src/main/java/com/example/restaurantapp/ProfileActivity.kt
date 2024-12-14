package com.example.restaurantapp

import android.widget.TextView
import android.os.Bundle
import android.content.Intent

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile) // Ensure this layout file exists

        // Find the "Sign Up" TextView
        val signUpLink = findViewById<TextView>(R.id.signUpLink)

        // Set a click listener
        signUpLink.setOnClickListener {
            // Redirect to SignUpActivity
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
