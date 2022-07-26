package com.bosonit.BP1.Estudiante.infrastructure.controller;

import com.bosonit.BP1.Errores.UnprocesableException;
import com.bosonit.BP1.Estudiante.application.EstudianteService;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostControllerStudent {

    @Autowired
    EstudianteService estudianteServicio;

    @PostMapping("/estudiante/{id}")
        public StudentOutputDtoFull postStudent(@RequestBody StudentInputDto studentInputDto, @PathVariable int id) throws Exception{
        try {
            return estudianteServicio.crearEstudianteFull(studentInputDto);
        }
        catch (Exception e) {
            throw new UnprocesableException("Revisa los campos");
        }
    }
}
