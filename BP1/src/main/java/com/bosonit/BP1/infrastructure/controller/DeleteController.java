package com.bosonit.BP1.infrastructure.controller;

import com.bosonit.BP1.infrastructure.repository.PersonaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    @Autowired
    PersonaRepositoryJPA personaRepositoryJPA;

    @DeleteMapping("/persona/{id}")
    String personaBorradaPorID(@PathVariable int id) throws Exception {
        try {
            personaRepositoryJPA.deleteById(id);
            return "Borrada persona con id: " + id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "La persona con el id no existe";
        }
    }
}
