package Practica1.Ejercicio7;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListaInvertida {
    public static void invertirArrayList(ArrayList<Integer> lista, int inicio, int fin) {
        int aux;
        if (inicio < fin){
            aux = lista.get(inicio);
            lista.set(inicio,lista.get(fin));
            lista.set(fin,aux);
            invertirArrayList(lista, inicio + 1, fin - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un numero (0 para finalizar): ");
        int n;
        while ((n = sc.nextInt()) != 0) {
            lista.add(n);
            System.out.print("Ingrese un numero (0 para finalizar): ");
        }
        System.out.println("Lista sin invertir: " + lista);
        invertirArrayList(lista, 0, lista.size() - 1);
        System.out.println("\nLista invertida: " + lista);
    }
}
