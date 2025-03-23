package Practica1.Ejercicio7;

import java.util.ArrayList;
import java.util.Scanner;

public class TestArrayList {

    public static void recorrerLista(ArrayList<Integer> lista) {
        for (int e : lista) {
            System.out.println("Numero: " + e);
        }

        /* Alternativa de recorrido 1
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Numero: " + lista.get(i));
        }

        Alternativa de recorrido 2
        while (lista.iterator().hasNext()) {
            System.out.println(lista.iterator().next());
        }
        */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList <>();
        System.out.println("Ingrese un numero: ");
        int n = sc.nextInt();
        while (n != 0) {
            list.add(n);
            System.out.println("Ingrese un numero: ");
            n = sc.nextInt();
        }
        recorrerLista(list);
    }
}
