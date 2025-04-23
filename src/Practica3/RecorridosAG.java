package Practica3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecorridosAG {


    // Metodo que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
    // pasados como parámetros, recorrido en preorden
    public static List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
        List<Integer> list = new ArrayList<>();
        if (!a.isEmpty())
            imparesMayoresPreOrden(list, a, n);
        return list;
    }

    private static void imparesMayoresPreOrden(List<Integer> list, GeneralTree<Integer> a, Integer n){
        if ((a.getData() % 2 != 0) && (a.getData() > n))
                list.add(a.getData());

        List<GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer> child : children) {
            imparesMayoresPreOrden(list, child, n);
        }
    }

    // Metodo que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
    // pasados como parámetros, recorrido en inorden.
    public static List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
        List<Integer> list = new ArrayList<>();
        if (!a.isEmpty())
            imparesMayoresInOrder(list, a, n);
        return list;
    }

    private static void imparesMayoresInOrder(List<Integer> list, GeneralTree<Integer> a, Integer n){
        List<GeneralTree<Integer>> children = a.getChildren();

        if (!children.isEmpty())
            //Proceso el primer hijo (el de mas a la izquierda)
            imparesMayoresInOrder(list, children.get(0), n);

        //Proceso el nodo actual
        if ((a.getData() % 2 != 0) && (a.getData() > n))
            list.add(a.getData());

        //Llamo recursivamente a partir del segundo hijo
        for (int i = 1; i < children.size(); i++) {
            imparesMayoresPreOrden(list,children.get(i), n);
        }
    }

    // Metodo que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
    // pasados como parámetros, recorrido en postorden.
    public static List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
        List<Integer> list = new ArrayList<>();
        if (!a.isEmpty())
            imparesMayoresPostOrder(list, a, n);
        return list;
    }

    private static void imparesMayoresPostOrder(List<Integer> list, GeneralTree<Integer> a, Integer n){
        //Proceso los hijos
        List<GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer> child : children) {
            imparesMayoresPreOrden(list, child, n);
        }

        //Por ultimo la raiz
        if ((a.getData() % 2 != 0) && (a.getData() > n))
            list.add(a.getData());

    }

    // Metodo que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
    // pasados como parámetros, recorrido por niveles.
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n){
        List<Integer> list = new ArrayList<>();

        GeneralTree<Integer> aux;

        Queue<GeneralTree<Integer>> queue = new Queue<>();
        queue.enqueue(a);

        while (!queue.isEmpty()) {
            aux = queue.dequeue();

            if ((aux.getData() % 2 != 0) && (aux.getData() > n))
                list.add(aux.getData());

            List<GeneralTree<Integer>> children = aux.getChildren();
            for (GeneralTree<Integer> child: children){
                queue.enqueue(child);
            }
        }

        return list;
    }


    public static void main(String[] args) {
        GeneralTree<Integer> a = new GeneralTree<>(1);
        a.addChildren(2,3,4,5,6);

        a.getChildren().get(0).addChildren(10,34,22,25);
        a.getChildren().get(1).addChildren(88);
        a.getChildren().get(4).addChildren(32, 54);
        a.getChildren().get(4).getChildren().get(1).addChildren(89);

        List<Integer> listImpares = numerosImparesMayoresQuePreOrden(a, 2);
        System.out.println(listImpares);

    }
}
