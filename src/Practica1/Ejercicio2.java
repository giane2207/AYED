package Practica1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {

    public static ArrayList<Integer> crearArregloMultiplos(int n) {
        ArrayList<Integer> arreglo = new ArrayList<>(n);
        for (int i = 1; i <= n ; i++) {
            arreglo.add(n*i);
        }
        return arreglo;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese un numero para ver sus multiplos (0 para salir): ");
        int n = s.nextInt();
        while (n != 0) {
            ArrayList<Integer> arreglo = crearArregloMultiplos(n);
            System.out.println("Los multiplos de " + n + " son: " + arreglo);
            System.out.println("Ingrese un numero para ver sus multiplos (0 para salir): ");
            n = s.nextInt();
        }
    }

}
