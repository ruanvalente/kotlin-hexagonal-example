package br.com.hexagonal.example.application.DTO.exceptions

import java.time.LocalDateTime

data class EmployeeExceptionDTO(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)
