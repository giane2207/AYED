package Practica2;

public class Transformacion {
    private final BinaryTree<Integer> a;

    public Transformacion(BinaryTree<Integer> a) {
        this.a = a;
    }

    public BinaryTree<Integer> suma (){
        tranformar(a);
        return a;
    }

    private int tranformar (BinaryTree<Integer> nodo) {
        if (nodo.isEmpty())
            return 0;

        //Me guardo el valor original de mi nodo actual
        int valorOriginal = nodo.getData();
        int sumaIzquierdo = 0;
        int sumaDerecho = 0;

        // Llamadas recursivas a los subarboles
        if (nodo.hasLeftChild())
             sumaIzquierdo = tranformar(nodo.getLeftChild());
        if (nodo.hasRightChild())
             sumaDerecho = tranformar(nodo.getRightChild());

        //Modifico el valor de mi nodo con la suma de sus subarboles
        nodo.setData(sumaIzquierdo + sumaDerecho);

        // Retorno el valor modificado y el valor original
        return valorOriginal + nodo.getData();
    }

    public static void preOrden(BinaryTree<Integer> nodo) {
        if (nodo == null || nodo.isEmpty()) return;

        System.out.print(nodo.getData() + " ");
        preOrden(nodo.getLeftChild());
        preOrden(nodo.getRightChild());
    }

    public static void main(String[] args) {
        // Armamos el árbol original:
        //         1
        //       /   \
        //      2     3
        //     /     / \
        //    4     5   6
        //         / \
        //        7   8

        BinaryTree<Integer> raiz = new BinaryTree<>(1);
        BinaryTree<Integer> n2 = new BinaryTree<>(2);
        BinaryTree<Integer> n3 = new BinaryTree<>(3);
        BinaryTree<Integer> n4 = new BinaryTree<>(4);
        BinaryTree<Integer> n5 = new BinaryTree<>(5);
        BinaryTree<Integer> n6 = new BinaryTree<>(6);
        BinaryTree<Integer> n7 = new BinaryTree<>(7);
        BinaryTree<Integer> n8 = new BinaryTree<>(8);

        raiz.addLeftChild(n2);
        raiz.addRightChild(n3);

        n2.addLeftChild(n4);

        n3.addLeftChild(n5);
        n3.addRightChild(n6);

        n5.addLeftChild(n7);
        n5.addRightChild(n8);

        // Aplicamos la transformación
        Transformacion t = new Transformacion(raiz);
        BinaryTree<Integer> transformado = t.suma();

        // Mostramos el árbol transformado (preorden por ejemplo)
        System.out.println("Árbol transformado (preorden):");
        preOrden(transformado);

    }
}
