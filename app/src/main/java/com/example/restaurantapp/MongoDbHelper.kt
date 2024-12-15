package com.example.restaurantapp

import org.bson.Document
import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.ServerApi
import com.mongodb.ServerApiVersion
import com.mongodb.kotlin.client.coroutine.MongoClient
import kotlinx.coroutines.runBlocking

object MongoDbHelper {

    // MongoDB connection string (replace with your credentials)
    private const val CONNECTION_STRING =
        "mongodb+srv://Blerton:Blerton@cluster0.0caoi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"

    // MongoDB client instance initialized lazily
    private val mongoClient: MongoClient by lazy {
        val serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1) // Use the Server API version V1
            .build()

        val settings = MongoClientSettings.builder()
            .applyConnectionString(ConnectionString(CONNECTION_STRING))
            .serverApi(serverApi)
            .build()

        println("MongoDB connection initialized successfully!")
        MongoClient.create(settings)
    }

    /**
     * Inserts a user document into the specified database and collection.
     * @param databaseName Name of the database.
     * @param collectionName Name of the collection.
     * @param user The user document to insert.
     */
    suspend fun insertUser(databaseName: String, collectionName: String, user: Document) {
        try {
            val database = mongoClient.getDatabase(databaseName)
            val collection = database.getCollection<Document>(collectionName)
            collection.insertOne(user)
            println("User inserted successfully into database '$databaseName' collection '$collectionName'")
        } catch (e: Exception) {
            println("Error inserting user: ${e.message}")
            throw e
        }
    }

    /**
     * Tests the MongoDB connection by pinging the database.
     * @param databaseName Name of the database to test.
     */
    fun testConnection(databaseName: String) = runBlocking {
        try {
            val database = mongoClient.getDatabase(databaseName)
            val pingCommand = Document("ping", 1)
            val result = database.runCommand(pingCommand)
            println("MongoDB connection test successful! Response: $result")
        } catch (e: Exception) {
            println("MongoDB connection test failed: ${e.message}")
            throw e
        }
    }

    /**
     * Closes the MongoDB client connection.
     */
    fun closeConnection() {
        try {
            mongoClient.close()
            println("MongoDB connection closed successfully.")
        } catch (e: Exception) {
            println("Error closing MongoDB connection: ${e.message}")
        }
    }
}
