package br.com.hexagonal.example.infrastructure.repository

import br.com.hexagonal.example.infrastructure.database.repositories.adapters.mongo.postgres.PostgresAdapterRepository

interface SpringDataEmployeeRepository : PostgresAdapterRepository {}