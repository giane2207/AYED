package Practica1.Ejercicio3;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        //Creo e inicializo los profes y estudiantes
        Estudiante estudiante1 = new Estudiante("Pedro", "Romero", "p@gmail.com", 10, "21 213");
        Estudiante estudiante2 = new Estudiante("Juan Cruz", "Montero", "jcm@gmail.com", 12, "83 213");
        Profesor profesor1 = new Profesor("Ruben", "Doblas", "rubiusOMG@fd.com", "ING1", "Facultad Informatica");
        Profesor profesor2 = new Profesor("Roberto", "Duungeon", "rub@fd.com", "FOD", "Facultad Informatica");
        Profesor profesor3 = new Profesor("Ana", "Dragons", "rub@fd.com", "AYED", "Facultad Informatica");

        // Creo y cargo los vectores
        ArrayList<Profesor> profesores = new ArrayList<>();
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(estudiante1);
        estudiantes.add(estudiante2);
        profesores.add(profesor1);
        profesores.add(profesor2);
        profesores.add(profesor3);

        //recorro vectores
        for (Profesor profesor : profesores) {
            System.out.println(profesor.tusDatos());
        }
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.tusDatos());
        }

    }
}
