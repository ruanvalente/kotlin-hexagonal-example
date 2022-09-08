package br.com.hexagonal.example.infrastructure.repository

import br.com.hexagonal.example.infrastructure.database.repositories.postgres.PostgreAdapterRepository

interface SpringDataEmployeeRepository: PostgreAdapterRepository {}