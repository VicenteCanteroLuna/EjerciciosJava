package com.bosonit.BP1.Estudiante.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentOutputDtoSimple {

    private int id_student;
    //private Persona persona;
    private int num_hours_week;
    private String coments;

    /*
     private Profesor profesor;
     private String branch;
     List<Alumnos_Estudios> estudios;
     */

}
