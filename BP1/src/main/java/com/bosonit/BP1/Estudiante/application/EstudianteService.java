package com.bosonit.BP1.Estudiante.application;

import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EstudianteService {

    StudentOutputDtoFull crearEstudiante(StudentInputDto studentInputDto) throws Exception;


    StudentOutputDtoSimple getStudentByID(int id, String ouputType) throws Exception;

    List<StudentOutputDtoFull> getAllStudent();
}
