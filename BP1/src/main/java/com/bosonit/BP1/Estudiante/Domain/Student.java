package com.bosonit.BP1.Estudiante.Domain;


import com.bosonit.BP1.Alumnos_estudios.domain.Alumnos_Estudios;
import com.bosonit.BP1.Errores.UnprocesableException;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import com.bosonit.BP1.Persona.Domain.Persona;
import com.bosonit.BP1.Profesor.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name= "Estudiantes")
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_student;

    @OneToOne
    @JoinColumn(name= "id_persona")
    private Persona persona;

    @Column(name= "Horas_por_semana")
    private int num_hours_week;

    @Column(name= "Comentarios")
    private String coments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "id_profesor")
    private Profesor profesor;

    @Column(name= "rama")
    //(columnDefinition = "VARCHAR(10) CHECK(branch IN ('FRONT', 'BACK', 'FULLSTACK'))")
    private String branch;

    @OneToMany
    List<Alumnos_Estudios> estudios;


    public void ValidadorEstudiante() throws Exception{
        if (String.valueOf(num_hours_week) == null){
            throw new UnprocesableException("Inserte número de horas");
        }
        if (branch == null){
            throw new UnprocesableException("Escoja entre Front, Back o Full");
        }
    }

    public Student (StudentInputDto studentInputDto){
        setNum_hours_week(studentInputDto.getNum_hours_week());
        setComents(studentInputDto.getComents());
        setBranch(studentInputDto.getBranch());
    }


    public void StudentInputDto(StudentInputDto studentInputDto) {
        this.setComents(studentInputDto.getComents());
        this.setNum_hours_week(studentInputDto.getNum_hours_week());
        this.setBranch(studentInputDto.getBranch());
    }

    public StudentOutputDtoSimple StudentToOutputDtoSimple(Student student) {

        StudentOutputDtoSimple studentOutputDtoSimple = new StudentOutputDtoSimple();
        studentOutputDtoSimple.setId_student(this.getId_student());
        studentOutputDtoSimple.setBranch(this.getBranch());
        studentOutputDtoSimple.setComents(this.getComents());
        studentOutputDtoSimple.setNum_hours_week(this.getNum_hours_week());

        return studentOutputDtoSimple;
    }

    public StudentOutputDtoFull StudentOutputDtoFull(Student student) {

        StudentOutputDtoFull studentOutputDtoFull = new StudentOutputDtoFull();
        studentOutputDtoFull.setId_student(this.getId_student());
        studentOutputDtoFull.setBranch(this.getBranch());
        studentOutputDtoFull.setComents(this.getComents());
        studentOutputDtoFull.setNum_hours_week(this.getNum_hours_week());
        studentOutputDtoFull.setPersona(this.getPersona());

        return studentOutputDtoFull;
    }


}
