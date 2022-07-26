package com.bosonit.BP1.Profesor.domain;


import com.bosonit.BP1.Persona.Domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name= "Profesor")
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_profesor;

    @OneToOne
    @JoinColumn(name= "id_persona")
    private Persona persona;

    private String coments;

    private String branch;

}
