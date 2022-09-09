package br.com.hexagonal.example.infrastructure.exceptions
import java.lang.RuntimeException
class EmployeeException(message: String?) : RuntimeException(message)