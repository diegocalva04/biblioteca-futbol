package com.example.bibliotecafutbol.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApiService {
    @GET("volumes")
    suspend fun searchBooks(@Query("q") query: String): BookSearchResponse

    @GET("volumes/{volumeId}")
    suspend fun getBook(@Path("volumeId") volumeId: String): BookDetailsResponse
}
