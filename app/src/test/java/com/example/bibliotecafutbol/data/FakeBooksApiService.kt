package com.example.bibliotecafutbol.data

import com.example.bibliotecafutbol.network.BookDetailsResponse
import com.example.bibliotecafutbol.network.BookImageLinks
import com.example.bibliotecafutbol.network.BookSearchItem
import com.example.bibliotecafutbol.network.BookSearchResponse
import com.example.bibliotecafutbol.network.BookVolumeInfo
import com.example.bibliotecafutbol.network.BooksApiService

class FakeBooksApiService : BooksApiService {
    val requestedIds = mutableListOf<String>()
    var requestedQuery: String? = null

    override suspend fun searchBooks(query: String): BookSearchResponse {
        requestedQuery = query
        return BookSearchResponse(listOf(BookSearchItem("book-1"), BookSearchItem("book-2")))
    }

    override suspend fun getBook(volumeId: String): BookDetailsResponse {
        requestedIds.add(volumeId)
        return when (volumeId) {
            "book-1" -> BookDetailsResponse(
                BookVolumeInfo("Football Tactics", BookImageLinks("http://example.org/cover.jpg"))
            )
            else -> BookDetailsResponse(BookVolumeInfo("The Football Book", null))
        }
    }
}
