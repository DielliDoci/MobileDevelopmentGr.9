package com.example.restaurantapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.bson.Document

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Find views by ID
        val usernameInput = findViewById<EditText>(R.id.usernameInput)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val signUpButton = findViewById<Button>(R.id.signUpButton)
        val loginRedirect = findViewById<TextView>(R.id.loginRedirect)

        // Handle Sign-Up Button Click
        signUpButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                val userDocument = Document("username", username)
                    .append("email", email)
                    .append("password", password)

                try {
                    // Insert user into MongoDB
                    MongoDbHelper.insertUser("your_database_name", "your_collection_name", userDocument)
                    Toast.makeText(this, "Sign-Up Successful!", Toast.LENGTH_SHORT).show()
                    finish() // Optionally close this activity after success
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(this, "Sign-Up Failed: ${e.message}", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            }
        }

        // Handle Redirect to Login
        loginRedirect.setOnClickListener {
            // Redirect to Login Activity
            finish() // Closes this activity; assumes the Login Activity is the previous one
        }
    }
}
