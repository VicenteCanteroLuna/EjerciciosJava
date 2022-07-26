package com.bosonit.BP1.Profesor.application;

import com.bosonit.BP1.Profesor.infrastructure.repository.ProfesorRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@AllArgsConstructor
public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    ProfesorRepositoryJpa profesorRepositoryJpa;
}
