package Practica1.Ejercicio7;

import java.util.ArrayList;
import java.util.Scanner;

public class Capicua {

    public static boolean esCapicua(ArrayList<Integer> lista) {
        int size = lista.size();

        //Este for recorre hasta la mitad de la lista y compara con la otra mitad
        for (int i = 0; i < size / 2; i++) {
            if (! lista.get(i).equals(lista.get(size - 1 - i))) {
                return false;  // Si no coinciden, no es capicua
            }
        }

        return true;  // Si todos los pares coinciden, es capicua
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList <>();
        System.out.println("Ingrese un numero (0 para terminar): ");
        int n;
        while ((n = sc.nextInt()) != 0) {
            list.add(n);  // Añadir el número a la lista
            System.out.println("Ingrese un numero (0 para terminar): ");
        }
        if (esCapicua(list)) System.out.println("El numero es capicua");
        else System.out.println("El numero no es capicua");
    }
}
