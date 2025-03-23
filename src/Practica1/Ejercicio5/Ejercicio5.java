package Practica1.Ejercicio5;

import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio5 {
    private static double min, max, promedio;

    public static double promedio (ArrayList<Integer> arreglo) {
        int sumaElementos = 0;
        for (int elemento : arreglo) {
            sumaElementos += elemento;
        }
        return (double) sumaElementos / arreglo.size();

    }

    //Inciso a
    public static ArrayList<Double> devuelvoConReturn (ArrayList<Integer> arreglo){
        ArrayList<Double> arreglo_resultados = new ArrayList<>(3);
        arreglo_resultados.add((double)Collections.min(arreglo));
        arreglo_resultados.add((double)Collections.max(arreglo));
        arreglo_resultados.add(promedio(arreglo));
        return arreglo_resultados;
    }

    //Inciso b
    public static void devuelvoConParametro(ArrayList<Integer> arreglo, Resultado resultado){
        resultado.setPromedio(promedio(arreglo));
        resultado.setMin(Collections.min(arreglo));
        resultado.setMax(Collections.max(arreglo));
    }

    //Inciso c
    public static void devuelvoSinParametro(ArrayList<Integer> arreglo){
        promedio = promedio(arreglo);
        min = Collections.min(arreglo);
        max = Collections.max(arreglo);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arreglo = new ArrayList<>();
        Resultado resultado = new Resultado();

        //cargo el arreglo
        arreglo.add(14);
        arreglo.add(28);
        arreglo.add(343);
        arreglo.add(48);
        arreglo.add(5);

        //a
        ArrayList<Double> arreglo_resultados = devuelvoConReturn(arreglo);
        //b
        devuelvoConParametro(arreglo, resultado);
        //c
        devuelvoSinParametro(arreglo);

        //imprimo los resultados de cada metodo
        System.out.println(arreglo_resultados);
        System.out.println(resultado);
        System.out.println("Promedio: " + promedio + " Min: " + min + " Max: " + max);

    }
}
