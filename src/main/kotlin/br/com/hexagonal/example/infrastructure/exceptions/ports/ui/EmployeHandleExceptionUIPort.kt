package br.com.hexagonal.example.infrastructure.exceptions.ports.ui

import br.com.hexagonal.example.application.DTO.exceptions.EmployeeExceptionDTO
import br.com.hexagonal.example.infrastructure.exceptions.EmployeeException
import org.springframework.web.bind.MethodArgumentNotValidException
import javax.servlet.http.HttpServletRequest

interface EmployeHandleExceptionUIPort {
    fun handleNotFound(
        exception: EmployeeException,
        request: HttpServletRequest
    ): EmployeeExceptionDTO

    fun handleValidationError(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): EmployeeExceptionDTO

    fun handleServerError(
        exception: Exception,
        request: HttpServletRequest
    ): EmployeeExceptionDTO
}