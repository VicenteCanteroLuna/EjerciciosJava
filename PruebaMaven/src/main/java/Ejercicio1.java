package PruebaMaven;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ejercicio1 {
    public static void main (String[] args) throws IOException {


        List<PruebaMaven.Persona> listaPersonas = new ArrayList<>();

        PruebaMaven.Persona  persona;


        String[] partes = new String[2];

        FileReader fr = new FileReader("C:/Users/vicente.cantero/Desktop/JAVA/Ejercicios/NombrePoblaciónEdad.txt");
        BufferedReader br = new BufferedReader(fr);

        String linea;
        while ((linea = br.readLine()) != null) {
            partes = linea.split(":");


            //Optional<Integer> edad = partes.length <= 2 ? Optional.empty() : Optional.of(Integer.parseInt(partes[2]));
            if ((partes.length == 2)) {
                persona = new PruebaMaven.Persona(partes[0], partes[1], Optional.of(99));
            /*if (partes[1]== ""){
                persona= new Persona(partes[0],"desconocido",Optional.of(Integer.parseInt(partes[2])));
            }*/
            } else {
                if (partes[1] == "") {
                    persona = new PruebaMaven.Persona(partes[0], "desconocido", Optional.of(Integer.parseInt(partes[2])));

                } else {
                    persona = new PruebaMaven.Persona(partes[0], partes[1], Optional.of(Integer.parseInt(partes[2])));
                }
            }
            //persona = new Persona(partes[0], partes[1].equals("") ? "desconocida" : partes[1], edad);

            listaPersonas.add(persona);


        }


        listaPersonas.stream()
                .filter(p ->
                {
                    if (p.getEdad().isEmpty())
                        return false;
                    else
                        return p.getEdad().get() < 25;
                })
                .forEach(p -> System.out.println(p));
    }}