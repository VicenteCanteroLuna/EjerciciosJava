package com.bosonit.BS41;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Configuration
public class Bs41Application {

	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(Bs41Application.class, args);
	}


	@Bean
	@Profile("perfil1")
	Perfiles damePerfil1()
	{
	return new Perfil1("..perfil1.." + getClass()) ;
	}

	@Bean
	@Profile("perfil2")
	Perfiles damePerfil2(){
		return new Perfil1("..perfil2.."+getClass());
	}

	String getProfile()
	{
		if (environment.getActiveProfiles()==null)
			return "default";
		String[] profiles= environment.getActiveProfiles();
		return profiles.length>0?profiles[0]:"default";
	}
}
