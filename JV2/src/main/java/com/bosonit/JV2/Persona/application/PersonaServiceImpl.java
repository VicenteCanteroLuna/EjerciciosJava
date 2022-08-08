package com.bosonit.JV2.Persona.application;

import com.bosonit.JV2.Persona.Domain.Persona;
import com.bosonit.JV2.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.JV2.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.JV2.Persona.infrastructure.repository.PersonaRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepositoryJPA personaRepositoryJPA;

    //CREATE-POST
    @Override
    public PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception{
        //creamos objeto con los parámetros input
        //validamos campos
        try {
            if (personaInputDTO.getUsuario() == null) {
                throw new RuntimeException("Usuario no puede ser nulo");
            }
            if (personaInputDTO.getUsuario().length() > 10) {
                throw new RuntimeException("Longitud de usuario no puede ser superior a 10 caracteres");
            }
            if (personaInputDTO.getPassword() == null) {
                throw new RuntimeException("Password no puede ser nulo");
            }
            if (personaInputDTO.getName() == null) {
                throw new RuntimeException("Name no puede ser nulo");
            }
            if (personaInputDTO.getCompany_email() == null) {
                throw new RuntimeException("Company_email no puede ser nulo");
            }
            if (personaInputDTO.getPersonal_email() == null) {
                throw new RuntimeException("Personal_email no puede ser nulo");
            }
            if (personaInputDTO.getActive() == null) {
                throw new RuntimeException("Active no puede ser nulo");
            }
            if (personaInputDTO.getCreated_date() == null) {
                throw new RuntimeException("Create_date no puede ser nulo");
            }

            Persona persona= new Persona(personaInputDTO);

            //guardamos el objeto de entrada
            personaRepositoryJPA.save(persona);
            //creamos objeto de salida y le pasamos los parámetros
            PersonaOutputDTO personaOutput= new PersonaOutputDTO(persona);
            return personaOutput;

        }catch(Exception e){
            throw new RuntimeException("Campos inválidos");
        }
    }

    //GET-DAME
    @Override
    public List<PersonaOutputDTO> findAll(String outputType) {
        //creamos lista de personas de salida
        List<PersonaOutputDTO> personas;
        //buscamos todas los objetos en el repositorio y los casteamos a nuestro objeto de salida
        personas = personaRepositoryJPA.findAll().stream().map(p -> new PersonaOutputDTO(p)).toList();

        return personas;
    }

    @Override
    public ResponseEntity<PersonaOutputDTO> findById(int id) throws Exception {

                Persona p = personaRepositoryJPA.findById(id).orElseThrow(() -> new Exception("Persona con id: " + id + "no encontrada."));
                PersonaOutputDTO persOutputDto = new PersonaOutputDTO(p);
                return new ResponseEntity<>(persOutputDto, HttpStatus.OK);

    }


    @Override
    public List<Object> findByUsuario(String usuario) throws Exception {

                List<Object> personas;
                personas =personaRepositoryJPA.findByUsuario(usuario).stream().map(p -> new PersonaOutputDTO(p)).collect(Collectors.toList());
                return personas;

    }

    @Override
    public PersonaOutputDTO actualizaPersona(int id, PersonaInputDTO personaInputDTO) {
       try {
           Persona personaEncontrada = personaRepositoryJPA.findById(id)
                   .orElseThrow(() -> new RuntimeException("Persona con esa id no encontrada"));

           personaEncontrada.actualiza(personaInputDTO);
           personaRepositoryJPA.save(personaEncontrada);

           return new PersonaOutputDTO(personaEncontrada);
       }catch (Exception e){
           throw new RuntimeException("Error");
       }

    }

    public ResponseEntity<String> personaBorradaPorID(@PathVariable int id) throws Exception {
        try {
            personaRepositoryJPA.deleteById(id);
            return new ResponseEntity<>(("Borrada persona con id: " + id),HttpStatus.OK);
         } catch (Exception e) {
            throw new RuntimeException("No existe el id");
         }
    }
}
