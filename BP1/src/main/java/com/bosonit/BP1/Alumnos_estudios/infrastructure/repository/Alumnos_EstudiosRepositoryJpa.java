package com.bosonit.BP1.Alumnos_estudios.infrastructure.repository;

import com.bosonit.BP1.Alumnos_estudios.domain.Alumnos_Estudios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Alumnos_EstudiosRepositoryJpa extends JpaRepository<Alumnos_Estudios, Integer> {
}
