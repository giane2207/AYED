package Practica1.Ejercicio7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

// Implemente un metodo recursivo que calcule la suma de los elementos en un LinkedList.

public class SumaDeElementos {

    public static int sumarRecursivo(LinkedList<Integer> lista, int inicio){
        if (inicio < lista.size())
            return lista.get(inicio) + sumarRecursivo(lista, inicio + 1);
        else return 0;
    }

    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un numero (0 para finalizar): ");
        int n;
        while ((n = sc.nextInt()) != 0) {
            lista.add(n);
            System.out.print("Ingrese un numero (0 para finalizar): ");
        }
        System.out.println("La suma de elementos es: " + sumarRecursivo(lista, 0));
        Collections.sort(lista);
    }
}
