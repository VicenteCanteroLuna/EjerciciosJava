package com.bosonit.BP1.Persona.infrastructure.controller;

import com.bosonit.BP1.Errores.NotFoundException;
import com.bosonit.BP1.Persona.application.PersonaService;
import com.bosonit.BP1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetController {

    @Autowired
    PersonaService personaService;


    @GetMapping("/persona")
    List<PersonaOutputDTO> getAllPersonas(@RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception{
        return personaService.findAll(outputType);
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<PersonaOutputDTO> getbyId(@PathVariable int id, @RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception {
        try{
           return personaService.findById(id, outputType);
        }catch(Exception e){
            throw new NotFoundException("No existe el id");
        }
    }

    @GetMapping("persona/usuario/{usuario}")
    public List<Object> damePersonaPorUsuario(@PathVariable (value= "usuario") String usuario, @RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception {
        try{
            return personaService.findByUsuario(usuario, outputType);
        }catch(Exception e){
            System.out.println("No encontrado");
            return null;
        }
    }


}
