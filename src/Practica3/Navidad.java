package Practica3;

import java.util.ArrayList;
import java.util.List;

public class Navidad {
    private GeneralTree<Integer> abeto;

    public Navidad(GeneralTree<Integer> abeto) {
        this.abeto = abeto;
    }

    public String esAbetoNavidenio(){
        if (abeto.isEmpty())
            return "El arbol esta vacio";
        if (esAbeto(this.abeto))
            return "Es abeto";
        else return "No es abeto";
    }

    private boolean esAbeto(GeneralTree<Integer> abeto){
        if (abeto.isLeaf())
            return true;

        int cantHijosHoja = 0;
        for (GeneralTree<Integer> child: abeto.getChildren()){
            if (child.isLeaf())
                cantHijosHoja++;

            //hago llamado recursivo
            else if (!esAbeto(child))
                    return false;
        }

        // chequeo si tiene al menos 3 hijos hoja
        return cantHijosHoja >= 3;
    }

    public static void main(String[] args) {
        // Hijos del nodo 2: 5, 6 y 7 (todos hojas)
        GeneralTree<Integer> nodo2 = new GeneralTree<>(2, List.of(
                new GeneralTree<>(5),
                new GeneralTree<>(6),
                new GeneralTree<>(7)
        ));

        // Nodo 3 y 4 son hojas
        GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
        GeneralTree<Integer> nodo8 = new GeneralTree<>(8);

        // Nodo raíz (1) tiene como hijos a 2, 3 y 4
        GeneralTree<Integer> raiz = new GeneralTree<>(1, List.of(nodo2, nodo3, nodo4, nodo8));

        // Instancio la clase y pruebo
        Navidad navidad = new Navidad(raiz);
        System.out.println(navidad.esAbetoNavidenio()); // debería decir que NO es un abeto
    }

}
