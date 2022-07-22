package com.bosonit.BP1.infrastructure.controller;

import com.bosonit.BP1.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.BP1.infrastructure.repository.PersonaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    @Autowired
    PersonaRepositoryJPA personaRepositoryJPA;

    @DeleteMapping("/persona/{id}")
    ResponseEntity<String> personaBorradaPorID(@PathVariable int id) throws Exception {
        try {
            personaRepositoryJPA.deleteById(id);
            return new ResponseEntity<>(("Borrada persona con id: " + id),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(("Persona no encontrada"), HttpStatus.NOT_ACCEPTABLE);
        }
    }


}
