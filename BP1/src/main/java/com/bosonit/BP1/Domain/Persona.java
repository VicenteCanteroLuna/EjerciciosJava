package com.bosonit.BP1.Domain;

import com.bosonit.BP1.infrastructure.controller.dto.input.PersonaInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "Persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue
    private int id_persona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;


    public Persona(PersonaInputDTO persona){
    setId_persona(persona.getId_persona());
    setUsuario(persona.getUsuario());
    setPassword(persona.getPassword());
    setName(persona.getName());
    setSurname(persona.getSurname());
    setCompany_email(persona.getCompany_email());
    setPersonal_email(persona.getPersonal_email());
    setCity(persona.getCity());
    setActive(persona.getActive());
    setCreated_date(persona.getCreated_date());
    setImagen_url(persona.getImagen_url());
    setTermination_date(persona.getTermination_date());

    }
}