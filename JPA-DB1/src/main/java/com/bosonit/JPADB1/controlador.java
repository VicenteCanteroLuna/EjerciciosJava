package com.bosonit.JPADB1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class controlador {

    @Autowired
    PersonaRepositorio personaRepositorio;


    List<Persona> listaPersonas = new ArrayList<>();

    //CREAR
    @PostMapping("/persona")
    public Persona añadirPersona(@RequestBody Persona p) throws Exception {
        if (p.getUsuario() == null) {
            throw new Exception("Usuario no puede ser nulo");
        }
        if (p.getUsuario().length() > 10) {
            throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres");
        }
        if (p.getPassword() == null) {
            throw new Exception("Password no puede ser nulo");
        }
        if (p.getName() == null) {
            throw new Exception("Name no puede ser nulo");
        }
        if (p.getCompany_email() == null) {
            throw new Exception("Company_email no puede ser nulo");
        }
        if (p.getPersonal_email() == null) {
            throw new Exception("Personal_email no puede ser nulo");
        }
        if (p.getActive() == null) {
            throw new Exception("Active no puede ser nulo");
        }
        if (p.getCreated_date() == null) {
            throw new Exception("Create_date no puede ser nulo");
        }
        personaRepositorio.save(p);
        return p;
    }

    //READ
    @GetMapping("/persona")
    public List<Persona> getAll() {
        return personaRepositorio.findAll();
    }

    @GetMapping("/persona/{id}")
    public Persona getbyId(@PathVariable int id) throws Exception {
        return personaRepositorio.findById(id).orElseThrow(() -> new Exception("No encontrado"));
    }

    @GetMapping("/persona/usuario/{usuario}")
    public List<Persona> findByUsuario(@PathVariable String usuario) {
        listaPersonas = personaRepositorio.findAll();
        List<Persona> personasDos;

        personasDos = listaPersonas.stream()
                .filter(p -> usuario.equals(p.getUsuario())).toList();

        return personasDos;
    }

    //DELETE
    @DeleteMapping("/persona/{id}")
    String personaBorradaPorID(@PathVariable int id){
        personaRepositorio.deleteById(id);
        return "borrado";

    }}



