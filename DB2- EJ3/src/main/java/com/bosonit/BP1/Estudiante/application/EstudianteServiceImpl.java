package com.bosonit.BP1.Estudiante.application;

import com.bosonit.BP1.Errores.UnprocesableException;
import com.bosonit.BP1.Estudiante.Domain.Student;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import com.bosonit.BP1.Estudiante.infrastructure.repository.StudentRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    StudentRepositoryJpa studentRepositoryJpa;


    @Override
    public StudentOutputDtoFull crearEstudianteFull(StudentInputDto studentInputDto) {
         Student student= new Student();
        try{
            studentRepositoryJpa.save(student.DtoToStudent(studentInputDto));
            return student.studentToDtoFull(student.DtoToStudent(studentInputDto));
        }catch (Exception e){
            throw new UnprocesableException(e.getMessage());
        }
    }

    @Override
    public StudentOutputDtoSimple crearEstudianteSimple(StudentInputDto studentInputDto) throws Exception {
        return null;
    }
}
