package com.bosonit.BP1.Estudiante.Domain;


import com.bosonit.BP1.Errores.UnprocesableException;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import com.bosonit.BP1.Persona.Domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "id_profesor")
    private Profesor profesor;

    @Column(name= "rama")
    private String branch;

    @OneToMany
    List<Alumnos_Estudios> estudios;
*/

    public void ValidadorEstudiante() throws Exception{
        if (String.valueOf(num_hours_week) == null){
            throw new UnprocesableException("Inserte número de horas");
        }
        /*if (branch == null){
            throw new UnprocesableException("Escoja entre Front, Back o Full");
        }*/
    }

    public Student DtoToStudent(StudentInputDto studentInputDto) throws Exception{
        try{
            Student student= new Student();
            student.setId_student(studentInputDto.getId_student());
            student.setPersona(studentInputDto.getPersona());
            student.setComents(studentInputDto.getComents());
            student.setNum_hours_week(studentInputDto.getNum_hours_week());
            student.ValidadorEstudiante();
            return student;
        }catch (Exception e){
            throw new UnprocesableException(e.getMessage());
        }
    }

    public StudentOutputDtoSimple StudentToDtoSimple (Student student){
        StudentOutputDtoSimple studentOutputDtoSimple = new StudentOutputDtoSimple();
        studentOutputDtoSimple.setId_student(student.getId_student());
        studentOutputDtoSimple.setComents(student.getComents());
        studentOutputDtoSimple.setNum_hours_week(studentOutputDtoSimple.getNum_hours_week());
    return studentOutputDtoSimple;
    }

    public StudentOutputDtoFull studentToDtoFull(Student student){
        StudentOutputDtoFull studentOutputDtoFull = new StudentOutputDtoFull();
        studentOutputDtoFull.setId_student(student.getId_student());
        studentOutputDtoFull.setPersona(student.getPersona());
        studentOutputDtoFull.setComents(student.getComents());
        studentOutputDtoFull.setNum_hours_week(studentOutputDtoFull.getNum_hours_week());
        return studentOutputDtoFull;
    }


}
