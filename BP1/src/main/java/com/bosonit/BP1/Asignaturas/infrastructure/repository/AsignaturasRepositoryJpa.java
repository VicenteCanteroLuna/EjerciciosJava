package com.bosonit.BP1.Asignaturas.infrastructure.repository;

import com.bosonit.BP1.Asignaturas.domain.Asignaturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturasRepositoryJpa extends JpaRepository<Asignaturas, Integer> {
}
