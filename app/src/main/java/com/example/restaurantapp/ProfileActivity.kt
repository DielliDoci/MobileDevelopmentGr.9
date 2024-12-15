package com.example.restaurantapp

import android.widget.Button
import android.widget.TextView
import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile) // Ensure this layout file exists

        // Find the "Sign Up" TextView
        val signUpLink = findViewById<TextView>(R.id.signUpLink)

        // Set a click listener for "Sign Up"
        signUpLink.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        // Find the "Login" Button
        val loginButton = findViewById<Button>(R.id.loginButton)

        // Set a click listener for "Login"
        loginButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
