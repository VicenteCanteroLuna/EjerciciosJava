package com.bosonit.BP1.application;

import com.bosonit.BP1.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.BP1.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

public interface PersonaService {
    //crear
    PersonaOutputDTO añadir(PersonaInputDTO personaInputDTO) throws Exception;

    //lista de todos
    List<PersonaOutputDTO> findAll();

    //Persona por Id
    PersonaOutputDTO findById(int id) throws Exception;

    //Lista de personas por nombre usuario
    List<PersonaOutputDTO> findByUsuario(String usuario) throws Exception;
}
