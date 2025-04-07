package Practica2;

import Practica1.Ejercicio8.Queue;

public class ProfundidadDeArbolBinario {
    private final BinaryTree<Integer> a;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> a) {
        this.a = a;
    }

    public int sumaElementosProfundidad(int p) {
        if (a == null) return 0;

        BinaryTree<Integer> node;
        Queue<BinaryTree<Integer>> queue = new Queue<>();

        queue.enqueue(a);
        queue.enqueue(null);

        int level = 0;
        int sum = 0;
        boolean terminar = false;

        while (!queue.isEmpty() && !terminar){
            node = queue.dequeue();

            if (node != null){
                if (level == p)
                    sum += node.getData();

                if (node.hasLeftChild())
                    queue.enqueue(node.getLeftChild());

                if (node.hasRightChild())
                    queue.enqueue(node.getRightChild());

            } else if (!queue.isEmpty()){
                level++;
                queue.enqueue(null);
                if (level > p)
                    terminar = true;
            }

        }
        return sum;
    }

    //Alternativa sin usar null como marca de fin de nivel
    public int sumaElementosProfundidad(int p) {
    if (a == null) return 0;

    Queue<BinaryTree<Integer>> queue = new Queue<>();
    queue.enqueue(a);
    int level = 0;

    while (!queue.isEmpty()) {
        int size = queue.size(); // Cantidad de nodos en este nivel

        if (level == p) {
            int sum = 0;
            for (int i = 0; i < size; i++) {
                BinaryTree<Integer> node = queue.dequeue();
                sum += node.getData();
                // No hace falta encolar hijos porque no voy a niveles más profundos
            }
            return sum;
        }

        for (int i = 0; i < size; i++) {
            BinaryTree<Integer> node = queue.dequeue();

            if (node.hasLeftChild()) queue.enqueue(node.getLeftChild());
            if (node.hasRightChild()) queue.enqueue(node.getRightChild());
        }

        level++;
    }

    return 0; // Si p es mayor que la profundidad del árbol
}

    public static void main(String[] args) {
        // Nivel 0
        BinaryTree<Integer> root = new BinaryTree<>(10);

        // Nivel 1
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo20 = new BinaryTree<>(20);
        root.addLeftChild(nodo5);
        root.addRightChild(nodo20);

        // Nivel 2
        BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo30 = new BinaryTree<>(30);
        nodo5.addLeftChild(nodo3);
        nodo5.addRightChild(nodo7);
        nodo20.addRightChild(nodo30);

        // Instancia de tu clase con el árbol armado
        ProfundidadDeArbolBinario profundizador;
        profundizador = new ProfundidadDeArbolBinario(root);

        // Pruebas
        System.out.println(profundizador.sumaElementosProfundidad(0)); // 10
        System.out.println(profundizador.sumaElementosProfundidad(1)); // 25
        System.out.println(profundizador.sumaElementosProfundidad(2)); // 40
        System.out.println(profundizador.sumaElementosProfundidad(3)); // 0 (no hay nivel 3)
    }



}
