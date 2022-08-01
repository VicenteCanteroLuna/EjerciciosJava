package com.bosonit.BP1.Profesor.infrastructure.controller;

import com.bosonit.BP1.Errores.NotFoundException;
import com.bosonit.BP1.Estudiante.infrastructure.repository.StudentRepositoryJpa;
import com.bosonit.BP1.Profesor.infrastructure.repository.ProfesorRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteControllerProfesor {

    @Autowired
    ProfesorRepositoryJpa profesorRepositoryJpa;

    @DeleteMapping("profesor/{id}")
    ResponseEntity<String> profesorBorradoID(@PathVariable int id)throws Exception{
        try{
            profesorRepositoryJpa.deleteById(id);
            return new ResponseEntity<>(("Borrado profesor con id: " + id), HttpStatus.OK);
        } catch (Exception e) {
            throw new NotFoundException("No existe el id");
        }
    }
}
