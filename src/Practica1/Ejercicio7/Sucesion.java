package Practica1.Ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sucesion {
    // Declaro la lista estatica para poder accederla y modificarla en los metodos
    private static List<Integer> lista;

    public static List<Integer> calcularSucesion (int n) {
        lista.add(n);
        //El caso de fin es cuando n = 1, que se va a agregar también.
        if (n > 1)
            if (n % 2 == 0)
                calcularSucesion(n / 2);
            else
                calcularSucesion(n * 3 + 1);
        return lista;
    }

    public static void main(String[] args) {
        lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un numero: ");
        int n = sc.nextInt();
        calcularSucesion(n);
        System.out.println(lista);
    }
}
