package br.com.hexagonal.example.application.DTO.requests

import java.math.BigInteger
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class EmployeeRequestDTO(
    @field:NotNull
    @field:NotBlank
    val name: String,

    @field:NotNull
    @field:NotBlank
    val role: String,

    @field:NotNull
    val salary: Int
)
