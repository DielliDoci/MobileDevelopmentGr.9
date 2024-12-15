package com.example.restaurantapp

import org.bson.Document
import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.ServerApi
import com.mongodb.ServerApiVersion
import com.mongodb.kotlin.client.coroutine.MongoClient
import kotlinx.coroutines.runBlocking

object MongoDbHelper {
    private const val CONNECTION_STRING = "mongodb+srv://Blerton:Blerton@cluster0.0caoi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
    private val mongoClient: MongoClient

    init {
        val serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build()
        val mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(ConnectionString(CONNECTION_STRING))
            .serverApi(serverApi)
            .build()
        mongoClient = MongoClient.create(mongoClientSettings)
    }

    fun insertUser(databaseName: String, collectionName: String, user: Document) {
        runBlocking {
            val database = mongoClient.getDatabase(databaseName)
            val collection = database.getCollection<Document>(collectionName)
            collection.insertOne(user)
            println("User inserted successfully!")
        }
    }
}
