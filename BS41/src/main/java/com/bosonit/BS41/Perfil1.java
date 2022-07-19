package com.bosonit.BS41;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Perfil1 implements Perfiles{
    private String profile;

    public Perfil1 (String profile){
        this.profile=profile;
    }


    @Override
    public void miFuncion(String log) {
        System.out.println("Perfil: " + profile+"->"+ log);
    }

    @Override
    public String getProfile() {
        return profile;
    }
}
