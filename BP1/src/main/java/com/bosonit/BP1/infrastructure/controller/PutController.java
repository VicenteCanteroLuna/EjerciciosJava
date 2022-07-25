package com.bosonit.BP1.infrastructure.controller;

import com.bosonit.BP1.Errores.NotFoundException;
import com.bosonit.BP1.Errores.UnprocesableException;
import com.bosonit.BP1.application.PersonaService;
import com.bosonit.BP1.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.BP1.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PutController {

    @Autowired
    PersonaService personaService;


    @RequestMapping(value = "/persona/{id}", method = RequestMethod.PUT)
    ResponseEntity<PersonaOutputDTO> actualizaPersona(@PathVariable("id") int id, @RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        try {
            return new ResponseEntity<>(personaService.actualizaPersona(id, personaInputDTO), HttpStatus.OK);
        } catch (Exception e) {
            throw new NotFoundException("No existe el id");
        }
    }
}

