package br.com.hexagonal.example.application.DTO.responses

import java.math.BigInteger

data class EmployeeResponseDTO(
    val name: String,
    val role: String,
    val salary: Int
)
