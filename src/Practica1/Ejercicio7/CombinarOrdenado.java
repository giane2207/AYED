package Practica1.Ejercicio7;

import java.util.ArrayList;
import java.util.Collections;

public class CombinarOrdenado {

    //Esta para mi es la manera facil pero hay una manera mas eficiente que no pienso hacer
    public static ArrayList<Integer> combinarOrdenado (ArrayList<Integer> lista1, ArrayList<Integer> lista2){
        ArrayList<Integer> aux = new ArrayList<>();
        aux.addAll(lista1);
        aux.addAll(lista2);
        Collections.sort(aux);
        return aux;
    }


    public static void main(String[] args) {
        ArrayList<Integer> lista1 = new ArrayList<>();
        lista1.add(1);
        lista1.add(3);
        lista1.add(5);
        lista1.add(7);

        ArrayList<Integer> lista2 = new ArrayList<>();
        lista2.add(2);
        lista2.add(4);
        lista2.add(6);
        lista2.add(8);

        ArrayList<Integer> lista_final = combinarOrdenado(lista1, lista2);

        System.out.println(lista_final);
    }
}
