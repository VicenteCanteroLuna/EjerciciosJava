package com.bosonit.BP1.infrastructure.repository;

import com.bosonit.BP1.Domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonaRepositoryJPA extends JpaRepository<Persona, Integer> {

    List<Persona> findByUsuario(String usuario);
}
