package com.bosonit.BP1.application;

import com.bosonit.BP1.Domain.Persona;
import com.bosonit.BP1.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.BP1.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.BP1.infrastructure.repository.PersonaRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepositoryJPA personaRepositoryJPA;

    //CREATE-POST
    @Override
    public PersonaOutputDTO añadir(PersonaInputDTO personaInputDTO) throws Exception{
        //creamos objeto con los parámetros input
        //validamos campos
        try {
            if (personaInputDTO.getUsuario() == null) {
                throw new Exception("Usuario no puede ser nulo");
            }
            if (personaInputDTO.getUsuario().length() > 10) {
                throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres");
            }
            if (personaInputDTO.getPassword() == null) {
                throw new Exception("Password no puede ser nulo");
            }
            if (personaInputDTO.getName() == null) {
                throw new Exception("Name no puede ser nulo");
            }
            if (personaInputDTO.getCompany_email() == null) {
                throw new Exception("Company_email no puede ser nulo");
            }
            if (personaInputDTO.getPersonal_email() == null) {
                throw new Exception("Personal_email no puede ser nulo");
            }
            if (personaInputDTO.getActive() == null) {
                throw new Exception("Active no puede ser nulo");
            }
            if (personaInputDTO.getCreated_date() == null) {
                throw new Exception("Create_date no puede ser nulo");
            }

            Persona persona= new Persona(personaInputDTO);

            //guardamos el objeto de entrada
            personaRepositoryJPA.save(persona);
            //creamos objeto de salida y le pasamos los parámetros
            PersonaOutputDTO personaOutput= new PersonaOutputDTO(persona);
            return personaOutput;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //GET-DAME
    @Override
    public List<PersonaOutputDTO> findAll() {
        //creamos lista de personas de salida
        List<PersonaOutputDTO> personas;
        //buscamos todas los objetos en el repositorio y los casteamos a nuestro objeto de salida
        personas = personaRepositoryJPA.findAll().stream().map(p -> new PersonaOutputDTO(p)).toList();

        return personas;
    }

    @Override
    public ResponseEntity<PersonaOutputDTO> findById(int id) throws Exception {
        try {
            Persona p = personaRepositoryJPA.findById(id).orElseThrow(() -> new Exception("Persona con id: " + id + "no encontrada."));
            PersonaOutputDTO persOutputDto = new PersonaOutputDTO(p);
            return new ResponseEntity<>(persOutputDto, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }


    @Override
    public List<PersonaOutputDTO> findByUsuario(String usuario) throws Exception {
        try {
        List<PersonaOutputDTO> personas;
        personas = personaRepositoryJPA.findByUsuario(usuario).stream().map(p -> new PersonaOutputDTO(p)).collect(Collectors.toList());
        return personas;
        }catch (Exception e){
            System.out.println("usuario no encontrado");
            return null;
        }
    }

    @Override
    public PersonaOutputDTO actualizaPersona(int id, PersonaInputDTO personaInputDTO) {
        Persona personaEncontrada= personaRepositoryJPA.findById(id)
                .orElseThrow(()->new RuntimeException("Persona con esa id no encontrada"));
        personaEncontrada.actualiza(personaInputDTO);
        personaRepositoryJPA.save(personaEncontrada);

        return new PersonaOutputDTO(personaEncontrada);
    }
}
