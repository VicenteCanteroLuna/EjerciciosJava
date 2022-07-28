package com.bosonit.BP1.Asignaturas.infrastructure.controller.dto;

import com.bosonit.BP1.Asignaturas.domain.Asignaturas;
import com.bosonit.BP1.Estudiante.Domain.Student;
import com.bosonit.BP1.Profesor.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturasOutputDtoFull extends AsignaturaOutputDto{

    private Profesor profesor;

    private Student student;

    public AsignaturasOutputDtoFull (Asignaturas asignaturas){
        setProfesor(asignaturas.getProfesor());
        setStudent(asignaturas.getStudent());

        setAsignatura(asignaturas.getAsignatura());
        setComment(asignaturas.getComment());
        setInitial_date(asignaturas.getInitial_date());
        setFinish_date(asignaturas.getFinish_date());
    }
}
