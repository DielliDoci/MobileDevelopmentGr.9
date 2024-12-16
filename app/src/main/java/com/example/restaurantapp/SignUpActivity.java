package com.example.restaurantapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText usernameInput, emailInput, passwordInput;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize views
        usernameInput = findViewById(R.id.usernameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        signUpButton = findViewById(R.id.signUpButton);

        // Sign-Up Button Click Listener
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    // Insert data into MongoDB
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            boolean success = insertDataToMongoDB(username, email, password);

                            runOnUiThread(() -> {
                                if (success) {
                                    Toast.makeText(SignUpActivity.this, "Sign-Up Successful!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(SignUpActivity.this, "Sign-Up Failed!", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
                }
            }
        });
    }

    private boolean insertDataToMongoDB(String username, String email, String password) {
        try {
            // MongoDB Connection String - Replace with your MongoDB URI
            String mongoURI = "mongodb://Blerton:Blerton@cluster0.mongodb.net/Mobile_Project?retryWrites=true&w=majority";

            // Connect to MongoDB
            MongoClientURI uri = new MongoClientURI(mongoURI);
            MongoClient mongoClient = new MongoClient(uri);

            // Access database and collection
            MongoDatabase database = mongoClient.getDatabase("Mobile_Project");
            MongoCollection<Document> collection = database.getCollection("accounts");

            // Insert user data
            Document user = new Document("username", username)
                    .append("email", email)
                    .append("password", password); // You should hash passwords in production!

            collection.insertOne(user);

            // Close the client
            mongoClient.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
