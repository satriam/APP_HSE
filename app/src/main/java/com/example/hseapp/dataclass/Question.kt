package com.example.hseapp.dataclass

data class Question(
    val `data`: List<Data>
)

data class Data(
    val attributes: Attributes,
    val id: Int
)

data class Attributes(
    val createdAt: String,
    val jenis: String,
    val pertanyaan: String,
    val publishedAt: String,
    val updatedAt: String
)