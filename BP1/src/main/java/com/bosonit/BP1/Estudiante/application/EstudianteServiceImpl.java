package com.bosonit.BP1.Estudiante.application;

import com.bosonit.BP1.Errores.UnprocesableException;
import com.bosonit.BP1.Estudiante.Domain.Student;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import com.bosonit.BP1.Estudiante.infrastructure.repository.StudentRepositoryJpa;
import com.bosonit.BP1.Persona.Domain.Persona;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.BP1.Persona.infrastructure.repository.PersonaRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    StudentRepositoryJpa studentRepositoryJpa;

    @Autowired
    PersonaRepositoryJPA personaRepositoryJPA;


    @Override
    public StudentOutputDtoFull crearEstudiante(StudentInputDto studentInputDto) {

            Student student= new Student(studentInputDto);
            Persona persona;
            persona= personaRepositoryJPA.findById((studentInputDto.getId_persona())).get();

            student.setPersona(persona);

            //guardamos el objeto estudiante de entrada + objeto persona
            studentRepositoryJpa.save(student);



            System.out.println("El estudiante: " + studentRepositoryJpa.findById(student.getId_student()) + " es la persona: " + studentRepositoryJpa.findById(persona.getId_persona()));
            System.out.println("La persona : " + personaRepositoryJPA.findById(persona.getId_persona()) + " es el estudiante: " + studentRepositoryJpa.findById(student.getId_student()));
           return student.StudentOutputDtoFull(student);

    }
}

