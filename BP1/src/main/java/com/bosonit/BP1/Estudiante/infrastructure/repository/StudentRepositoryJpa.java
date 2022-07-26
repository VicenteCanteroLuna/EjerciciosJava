package com.bosonit.BP1.Estudiante.infrastructure.repository;

import com.bosonit.BP1.Estudiante.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryJpa extends JpaRepository<Student, Integer> {
}
