package com.example.bibliotecafutbol.data

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkBooksRepositoryTest {
    @Test
    fun getBooksSearchesSoccerAndLoadsEachVolumeSequentially() = runBlocking {
        val service = FakeBooksApiService()
        val repository = NetworkBooksRepository(service)

        val books = repository.getBooks()

        assertEquals("soccer", service.requestedQuery)
        assertEquals(listOf("book-1", "book-2"), service.requestedIds)
        assertEquals(
            listOf(
                Book("book-1", "Football Tactics", "https://example.org/cover.jpg"),
                Book("book-2", "The Football Book", null)
            ),
            books
        )
    }
}
