package com.bosonit.BS41;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controlador {

@Autowired
    Variables variable;

    @GetMapping("/parametros")
    String dameParametros(){

        return "valor de url es " + variable.getUrl() + " valor de password es " +variable.getPassword() ;
    }

}
