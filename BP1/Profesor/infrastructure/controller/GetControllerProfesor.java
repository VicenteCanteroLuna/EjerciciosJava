package com.bosonit.BP1.Profesor.infrastructure.controller;

import com.bosonit.BP1.Estudiante.application.EstudianteService;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import com.bosonit.BP1.Profesor.application.ProfesorService;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorOutputDto;
import com.bosonit.BP1.Profesor.infrastructure.controller.dto.ProfesorOutputDtoFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profesor/")
public class GetControllerProfesor {

        @Autowired
        ProfesorService profesorService;

        @GetMapping("{id}")
        public ProfesorOutputDto dameProfesoresPorID(@PathVariable int id, @RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception {
            return profesorService.dameProfesorId(id, outputType);

        }

        @GetMapping("todos")
        public List<ProfesorOutputDtoFull> dameProfesores() {
            return profesorService.dameProfesores();
        }
}
