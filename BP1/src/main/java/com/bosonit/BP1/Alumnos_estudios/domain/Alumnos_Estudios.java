package com.bosonit.BP1.Alumnos_estudios.domain;

import com.bosonit.BP1.Estudiante.Domain.Student;
import com.bosonit.BP1.Profesor.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name= "Estudios")
@NoArgsConstructor
@AllArgsConstructor
public class Alumnos_Estudios {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_study;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Profesor profesor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    Student student;

    @Column(name = "asignatura")
    String asignatura;

    @Column(name = "comentarios")
    String comment;

    @Column(name = "initial_date")
    Date initial_date;

    @Column(name = "finish_date")
    Date finish_date;

}
