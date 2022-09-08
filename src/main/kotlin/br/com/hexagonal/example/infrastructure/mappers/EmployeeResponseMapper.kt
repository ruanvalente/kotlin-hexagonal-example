package br.com.hexagonal.example.infrastructure.mappers

import br.com.hexagonal.example.application.DTO.requests.EmployeeRequestDTO
import br.com.hexagonal.example.application.DTO.responses.EmployeeResponseDTO
import org.springframework.stereotype.Component

@Component
class EmployeeResponseMapper : Mapper<EmployeeRequestDTO, EmployeeResponseDTO> {
    override fun mapper(t: EmployeeRequestDTO): EmployeeResponseDTO {
        return EmployeeResponseDTO(
            name = t.name, role = t.role, salary = t.salary
        )
    }
}