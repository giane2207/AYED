package Practica1.Ejercicio7;

import Practica1.Ejercicio3.Estudiante;

import java.util.ArrayList;

public class CopiasDeListas {
    public static void imprimirLista(ArrayList<Estudiante> lista) {
        for(Estudiante e : lista) {
            System.out.println(e.tusDatos());
        }
    }

    public static void imprimirListas(ArrayList<Estudiante> lista, ArrayList<Estudiante> lista2) {
        System.out.println("\n Lista de Estudiantes: ");
        imprimirLista(lista);
        System.out.println("\n Copia de la lista de Estudiantes: ");
        imprimirLista(lista2);
    }

    public static void agregarEstudiante(ArrayList<Estudiante> lista, Estudiante estudiante) {
        if (! lista.contains(estudiante)) {
            lista.add(estudiante);
        }
    }

    public static void main(String[] args) {
        //Creo e inicializo los estudiantes
        Estudiante estudiante1 = new Estudiante("Juan", "Perez", "j@mail.com", 10, "321");
        Estudiante estudiante2 = new Estudiante("Graciela", "Romero", "g@mail.com", 12, "3e321");
        Estudiante estudiante3 = new Estudiante("Ruben", "Doblas", "rd@mail.com", 120, "andorra");

        //Creo la lista y cargo estudiantes
        ArrayList<Estudiante> lista = new ArrayList<>();
        lista.add(estudiante1);
        lista.add(estudiante2);
        lista.add(estudiante3);

        //Genero una copia de la lista de estudiantes
        ArrayList<Estudiante> estudiantes_copy = new ArrayList<>(lista);

        //Imprimo las listas
        imprimirListas(lista, estudiantes_copy);

        //Modifico un estudiante e imprimo
        estudiante2.setNombre("Juana");
        System.out.println("Listas con modificacion de estudiante: ");
        imprimirListas(lista, estudiantes_copy);

        //Agrego nuevo estudiante a la lista e imprimo
        Estudiante nuevoEstudiante = new Estudiante("Catalina", "Suarez", "cs@mail.com", 3, "santa cruz");
        agregarEstudiante(lista, nuevoEstudiante);
        agregarEstudiante(lista, estudiante3);

        imprimirListas(lista, estudiantes_copy);

        /* Alternativas para generar una copia de una lista

        ArrayList<Estudiante> estudiantes_copy2 = new ArrayList<>();
        estudiantes_copy2.addAll(lista);

        ArrayList<Estudiante> estudiantes_copy3 = (ArrayList<Estudiante>) lista.clone();

        */

    }
}
