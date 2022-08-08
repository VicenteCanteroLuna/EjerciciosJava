package com.bosonit.JV2.Persona.infrastructure.controller;

import com.bosonit.JV2.Persona.application.PersonaService;
import com.bosonit.JV2.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
public class GetController {

    @Autowired
    PersonaService personaService;


    @GetMapping("/getall")
    List<PersonaOutputDTO> getAllPersonas(@RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception{
        return personaService.findAll(outputType);
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<PersonaOutputDTO> getbyId(@PathVariable int id, @RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception {
        try{
           return personaService.findById(id);
        }catch(Exception e){
            throw new RuntimeException("No existe el id");
        }
    }

    @GetMapping("persona/usuario/{usuario}")
    public List<Object> damePersonaPorUsuario(@PathVariable (value= "usuario") String usuario, @RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception {
        try{
            return personaService.findByUsuario(usuario);
        }catch(Exception e){
            System.out.println("No encontrado");
            return null;
        }
    }



}
