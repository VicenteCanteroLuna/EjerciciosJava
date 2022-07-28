package com.bosonit.BP1.Asignaturas.domain;

import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturasInputDto;
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
public class Asignaturas {

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


    public Asignaturas(AsignaturasInputDto asignaturasInputDto) {
        setAsignatura(asignaturasInputDto.getAsignatura());
        setComment(asignaturasInputDto.getComment());
        setInitial_date(asignaturasInputDto.getInitial_date());
        setFinish_date(asignaturasInputDto.getFinish_date());
    }

    public void AsignaturasInputDto(AsignaturasInputDto asignaturasInputDto) {
        this.setAsignatura(asignaturasInputDto.getAsignatura());
        this.setComment(asignaturasInputDto.getComment());
        this.setInitial_date(asignaturasInputDto.getInitial_date());
        this.setFinish_date(asignaturasInputDto.getFinish_date());
    }

    public AsignaturaOutputDto AsignaturaOutputDto(Asignaturas asignaturas) {

        AsignaturaOutputDto asignaturaOutputDto = new AsignaturaOutputDto();
        asignaturaOutputDto.setAsignatura(this.getAsignatura());
        asignaturaOutputDto.setComment(this.getComment());
        asignaturaOutputDto.setInitial_date(this.getInitial_date());
        asignaturaOutputDto.setFinish_date(this.getFinish_date());

        return asignaturaOutputDto;
    }

    /*PARA EL FULL
    public ProfesorOutputDtoFull ProfesorOutputDtoFull(Profesor profesor) {

        ProfesorOutputDtoFull profesorOutputDtoFull = new ProfesorOutputDtoFull();
        profesorOutputDtoFull.setId_profesor(this.getId_profesor());
        profesorOutputDtoFull.setBranch(this.getBranch());
        profesorOutputDtoFull.setComents(this.getComents());
        profesorOutputDtoFull.setPersona(this.getPersona());

        return profesorOutputDtoFull;
    }


    public void actualiza(ProfesorInputDto profesorInputDTO) throws Exception{
        try {
            if (profesorInputDTO.getComents() != null) {
                setComents(profesorInputDTO.getComents());
            }
            if (profesorInputDTO.getBranch() != null) {
                setBranch(profesorInputDTO.getBranch());
            }
        }catch (Exception e){
            throw new UnprocesableException("Campos erróneos");
        }
    }   */
}
