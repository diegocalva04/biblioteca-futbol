package com.example.bibliotecafutbol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.platform.LocalContext
import com.example.bibliotecafutbol.ui.BookshelfScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val application = LocalContext.current.applicationContext as BibliotecaFutbolApplication
                Surface(modifier = Modifier.fillMaxSize()) {
                    BookshelfScreen(application.container.booksRepository)
                }
            }
        }
    }
}
