package Practica2;

public class ParcialArboles {
    private BinaryTree<Integer> a;

    public ParcialArboles(BinaryTree<Integer> a) {
        this.a = a;
    }

    public boolean isLeftTree(int num){
        BinaryTree<Integer> nodo = buscarNodo(num, a);

        int cantHijosIzq;
        int cantHijosDer;

        //Si se encontro el nodo de raiz "num"
        if (nodo == null)
            return false;

        if (nodo.hasLeftChild())
            cantHijosIzq = contarUnicoHijo(nodo.getLeftChild());
        else cantHijosIzq = -1;

        if (nodo.hasRightChild())
            cantHijosDer = contarUnicoHijo(nodo.getRightChild());
        else cantHijosDer = -1;

        return cantHijosIzq > cantHijosDer;
    }

    private BinaryTree<Integer> buscarNodo(int num, BinaryTree<Integer> a){
        if (a.isEmpty())
            return null;

        if (a.getData() == num)
            return a;

        //Inicializo la variable donde voy a guardar el nodo buscado
        BinaryTree<Integer> nodoEncontrado = null;

        if (a.hasLeftChild()) {
            nodoEncontrado = buscarNodo(num, a.getLeftChild());
            if (nodoEncontrado != null)
                return nodoEncontrado;
        }

        if (a.hasRightChild()) {
            nodoEncontrado = buscarNodo(num, a.getRightChild());
            if (nodoEncontrado != null)
                return nodoEncontrado;
        }

        //Si no lo encuentra retorna null
        return null;
    }

    private boolean tengoHijoUnico (BinaryTree<Integer> nodo){
        return  (nodo.hasLeftChild() && !nodo.hasRightChild() ||
                !nodo.hasLeftChild() && nodo.hasRightChild() );
    }

    private int contarUnicoHijo (BinaryTree<Integer> nodo){
        if (nodo.isEmpty())
            return 0;

        int suma = 0;

        if (tengoHijoUnico(nodo))
            suma += 1;

        if (nodo.hasLeftChild())
            suma += contarUnicoHijo(nodo.getLeftChild());

        if (nodo.hasRightChild())
            suma += contarUnicoHijo(nodo.getRightChild());

        return suma;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(2);

        BinaryTree<Integer> n7 = new BinaryTree<>(7);
        BinaryTree<Integer> n_5 = new BinaryTree<>(-5);
        root.addLeftChild(n7);
        root.addRightChild(n_5);

        BinaryTree<Integer> n23 = new BinaryTree<>(23);
        BinaryTree<Integer> n6 = new BinaryTree<>(6);
        n7.addLeftChild(n23);
        n7.addRightChild(n6);

        BinaryTree<Integer> n_3 = new BinaryTree<>(-3);
        n23.addLeftChild(n_3);

        BinaryTree<Integer> n55 = new BinaryTree<>(55);
        BinaryTree<Integer> n11 = new BinaryTree<>(11);
        n6.addLeftChild(n55);
        n6.addRightChild(n11);

        BinaryTree<Integer> n19 = new BinaryTree<>(19);
        n_5.addLeftChild(n19);

        BinaryTree<Integer> n4 = new BinaryTree<>(4);
        n19.addRightChild(n4);

        BinaryTree<Integer> n18 = new BinaryTree<>(18);
        n4.addLeftChild(n18);

       
        ParcialArboles pa = new ParcialArboles(root);

        System.out.println("isLeftTree(7): " + pa.isLeftTree(7));   // true
        System.out.println("isLeftTree(2): " + pa.isLeftTree(2));   // false
        System.out.println("isLeftTree(-5): " + pa.isLeftTree(-5)); // true
        System.out.println("isLeftTree(19): " + pa.isLeftTree(19)); // false
        System.out.println("isLeftTree(-3): " + pa.isLeftTree(-3)); // false
    }

}
