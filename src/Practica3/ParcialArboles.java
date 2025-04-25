package Practica3;

import java.util.ArrayList;
import java.util.List;

public class ParcialArboles {

    public static boolean esDeSeleccion (GeneralTree<Integer> arbol){
        if (arbol.isLeaf())
            return true;

        int min = Integer.MAX_VALUE;
        for (GeneralTree<Integer> child: arbol.getChildren()) {
            min = Math.min(child.getData(), min);
        }

        return arbol.getData().equals(min);
    }

    public static List<Integer> resolver(GeneralTree<Integer> arbol){
        List<Integer> caminoActual = new ArrayList<>();
        List<Integer> caminoMax = new ArrayList<>();

        // clase mutable para usar como parametro por referencia
        ContenedorMax max = new ContenedorMax(-1);

        if (arbol != null && !arbol.isEmpty())
            resolver(arbol, caminoActual, caminoMax, 0, 0, max);

        return caminoMax;
    }

    private static void resolver(GeneralTree<Integer> nodo, List<Integer> caminoActual,
                                 List<Integer> caminoMax, int nivelActual, int sumaParcial, ContenedorMax sumaMax){

        int valor = nodo.getData();
        int sumaActual = sumaParcial + (valor * nivelActual);

        if (valor == 1)
            caminoActual.add(1);

        if (nodo.isLeaf()) {
            if (sumaActual > sumaMax.getValor()) {
                sumaMax.setValor(sumaActual);
                caminoMax.clear();
                caminoMax.addAll(caminoActual);
            }
        } else
            for (GeneralTree<Integer> child: nodo.getChildren()){
                resolver(child, caminoActual, caminoMax, nivelActual + 1, sumaActual, sumaMax);
            }

        if (valor == 1)
            caminoActual.remove(caminoActual.size() - 1);
    }

    public static class ContenedorMax {
        public int valor;

        public ContenedorMax(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }
    }

    public static boolean esCreciente(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty())
            return false;

        GeneralTree<Integer> aux;

        Queue<GeneralTree<Integer>> queue = new Queue<>();
        queue.enqueue(arbol);
        int cantNivelAnterior = 0;
        boolean creciente = true;

        // recorro el arbol por niveles hasta encontrar un nivel que no cumpla la condicion de crecimiento o hasta terminar
        while (!queue.isEmpty() && creciente) {
            int size = queue.size(); // cantidad de nodos en el nivel actual

            // verifico si la cantidad de nodos del nivel actual es uno mas que la del nivel anterior
            if (size != cantNivelAnterior + 1)
                creciente = false;
            else
                cantNivelAnterior++; // actualizo para el próximo nivel

            // encolo los hijos de todos los nodos del nivel actual para procesar el siguiente nivel
            for (int i = 0; i < size; i++) {
                aux = queue.dequeue();
                for (GeneralTree<Integer> child : aux.getChildren()) {
                    queue.enqueue(child);
                }
            }
        }
        return creciente;
    }
}
