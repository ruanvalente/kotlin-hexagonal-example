package br.com.hexagonal.example.infrastructure.exceptions

import br.com.hexagonal.example.application.DTO.exceptions.EmployeeExceptionDTO
import br.com.hexagonal.example.infrastructure.exceptions.ports.ui.EmployeHandleExceptionUIPort
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class HandleException : EmployeHandleExceptionUIPort {

    @ExceptionHandler(EmployeeException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    override fun handleNotFound(
        exception: EmployeeException,
        request: HttpServletRequest
    ): EmployeeExceptionDTO {
        return EmployeeExceptionDTO(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message,
            path = request.servletPath
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    override fun handleValidationError(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): EmployeeExceptionDTO {
        val errorMessage = HashMap<String, String?>()

        exception.bindingResult.fieldErrors.forEach { e ->
            errorMessage.put(
                e.field,
                e.defaultMessage
            )
        }
        return EmployeeExceptionDTO(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = errorMessage.toString(),
            path = request.servletPath
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    override fun handleServerError(
        exception: Exception,
        request: HttpServletRequest
    ): EmployeeExceptionDTO {
        return EmployeeExceptionDTO(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = exception.message,
            path = request.servletPath
        )
    }
}
