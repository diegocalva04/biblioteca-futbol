package com.example.bibliotecafutbol.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.bibliotecafutbol.data.BooksRepository
import kotlinx.coroutines.launch
import java.io.IOException
import retrofit2.HttpException

class BooksViewModel(
    private val repository: BooksRepository
) : ViewModel() {
    var uiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    init {
        viewModelScope.launch {
            uiState = try {
                BooksUiState.Success(repository.getBooks())
            } catch (_: IOException) {
                BooksUiState.Error
            } catch (_: HttpException) {
                BooksUiState.Error
            }
        }
    }

    companion object {
        fun factory(repository: BooksRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T =
                    BooksViewModel(repository) as T
            }
    }
}
