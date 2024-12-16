package com.example.restaurantapp

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object MySQLDatabaseHelper {
    private const val DB_URL = "jdbc:mysql://10.0.2.2:3306/restaurantapp"
    private const val USER = "root"
    private const val PASSWORD = "toni"

    // Establish Connection
    fun getConnection(): Connection? {
        return try {
            DriverManager.getConnection(DB_URL, USER, PASSWORD)
        } catch (e: Exception) {
            e.printStackTrace()
            null // Return null if connection fails
        }
    }



    // Insert User into MySQL Database
    suspend fun insertUser(username: String, email: String, password: String) {
        withContext(Dispatchers.IO) {
            val connection = getConnection()
            connection?.use {
                try {
                    val sql = "INSERT INTO accounts (username, email, password) VALUES (?, ?, ?)"
                    val preparedStatement: PreparedStatement = it.prepareStatement(sql)
                    preparedStatement.setString(1, username)
                    preparedStatement.setString(2, email)
                    preparedStatement.setString(3, password)
                    preparedStatement.executeUpdate()
                } catch (e: Exception) {
                    e.printStackTrace() // Log the error
                    throw e // Propagate exception to calling function
                }
            } ?: throw Exception("Failed to establish a database connection")
        }
    }

}
