package com.example.bibliotecafutbol.data

import com.example.bibliotecafutbol.network.BooksApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val booksRepository: BooksRepository
}

class DefaultAppContainer : AppContainer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/books/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }

    override val booksRepository: BooksRepository by lazy {
        NetworkBooksRepository(apiService)
    }
}
