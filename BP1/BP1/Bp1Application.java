package com.bosonit.BP1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan
public class Bp1Application {

	public static void main(String[] args) {
		SpringApplication.run(Bp1Application.class, args);
	}

}
