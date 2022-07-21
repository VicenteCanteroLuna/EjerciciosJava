package com.bosonit.BP1.infrastructure.controller;

import com.bosonit.BP1.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutController {

    @Autowired
    PersonaService personaService;

}

