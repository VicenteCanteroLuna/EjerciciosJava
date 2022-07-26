package com.bosonit.BP1.Persona.application;

import com.bosonit.BP1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonaService {
    //crear
    PersonaOutputDTO añadir(PersonaInputDTO personaInputDTO) throws Exception;

    //lista de todos
    List<PersonaOutputDTO> findAll();

    //Persona por Id
    ResponseEntity<PersonaOutputDTO> findById(int id) throws Exception;

    //Lista de personas por nombre usuario
    List<PersonaOutputDTO> findByUsuario(String usuario) throws Exception;

    PersonaOutputDTO actualizaPersona(int id, PersonaInputDTO personaInputDTO);
}
