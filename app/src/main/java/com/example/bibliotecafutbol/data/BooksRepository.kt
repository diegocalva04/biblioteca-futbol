package com.example.bibliotecafutbol.data

import com.example.bibliotecafutbol.network.BooksApiService

interface BooksRepository {
    suspend fun getBooks(): List<Book>
}

class NetworkBooksRepository(
    private val apiService: BooksApiService
) : BooksRepository {
    override suspend fun getBooks(): List<Book> {
        val bookIds = apiService.searchBooks(SEARCH_QUERY).items
            .orEmpty()
            .mapNotNull { it.id }
            .take(MAX_BOOKS)

        val books = mutableListOf<Book>()
        for (bookId in bookIds) {
            val volumeInfo = apiService.getBook(bookId).volumeInfo ?: continue
            val title = volumeInfo.title ?: continue
            val thumbnail = volumeInfo.imageLinks?.thumbnail
                ?.replace("http://", "https://")
            books.add(Book(bookId, title, thumbnail))
        }
        return books
    }

    private companion object {
        const val SEARCH_QUERY = "football"
        const val MAX_BOOKS = 20
    }
}
