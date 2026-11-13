package com.example.bibliotecafutbol.ui

import com.example.bibliotecafutbol.data.Book

sealed interface BooksUiState {
    data object Loading : BooksUiState
    data class Success(val books: List<Book>) : BooksUiState
    data object Error : BooksUiState
}
