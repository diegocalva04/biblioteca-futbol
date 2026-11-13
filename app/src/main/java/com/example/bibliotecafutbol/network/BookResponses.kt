package com.example.bibliotecafutbol.network

import com.google.gson.annotations.SerializedName

data class BookSearchResponse(
    @SerializedName("items") val items: List<BookSearchItem>?
)

data class BookSearchItem(
    @SerializedName("id") val id: String?
)

data class BookDetailsResponse(
    @SerializedName("volumeInfo") val volumeInfo: BookVolumeInfo?
)

data class BookVolumeInfo(
    @SerializedName("title") val title: String?,
    @SerializedName("imageLinks") val imageLinks: BookImageLinks?
)

data class BookImageLinks(
    @SerializedName("thumbnail") val thumbnail: String?
)
