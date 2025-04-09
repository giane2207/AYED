package Practica2;

public class TestParcialArboles {
    public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree<>(20);

        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo30 = new BinaryTree<>(30);
        raiz.addLeftChild(nodo5);
        raiz.addRightChild(nodo30);

        BinaryTree<Integer> nodoMenos5 = new BinaryTree<>(-5);
        BinaryTree<Integer> nodo10 = new BinaryTree<>(10);
        nodo5.addLeftChild(nodoMenos5);
        nodo5.addRightChild(nodo10);

        BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
        nodo10.addLeftChild(nodo1);

        BinaryTree<Integer> nodo50 = new BinaryTree<>(50);
        BinaryTree<Integer> nodoMenos9 = new BinaryTree<>(-9);
        nodo30.addLeftChild(nodo50);
        nodo30.addRightChild(nodoMenos9);

        BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
        nodo50.addLeftChild(nodo4);

        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
        nodo4.addRightChild(nodo6);

        // Llamamos al metodo sumAndDif
        ParcialArboles pa = new ParcialArboles(raiz);
        BinaryTree<Par> nuevoArbol = pa.sumAndDif(raiz);

        // Metodo para imprimir el árbol en preorden con los valores de Par
        imprimirPreorden(nuevoArbol);
    }

    public static void imprimirPreorden(BinaryTree<Par> nodo) {
        if (nodo == null || nodo.isEmpty()) return;
        System.out.println("Suma: " + nodo.getData().getSum() + " | Diferencia: " + nodo.getData().getDif());
        if (nodo.hasLeftChild()) imprimirPreorden(nodo.getLeftChild());
        if (nodo.hasRightChild()) imprimirPreorden(nodo.getRightChild());
    }
}
