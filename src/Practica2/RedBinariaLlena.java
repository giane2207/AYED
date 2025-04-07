package Practica2;


public class RedBinariaLlena {
    private BinaryTree<Integer> a;

    public RedBinariaLlena() {
        this.a = new BinaryTree<>();
    }

    public int retardoReenvio(){
        return retardoReenvio(this.a);
    }

    private int retardoReenvio(BinaryTree<Integer> arbol){
        if (arbol.isLeaf())
            return arbol.getData();

        //Inicializo variables para buscar maximo
        int left = 0; int right = 0;

        if (arbol.hasLeftChild())
            left = retardoReenvio(arbol.getLeftChild());

        if (arbol.hasRightChild())
            right = retardoReenvio(arbol.getRightChild());

        //Determino el maximo de los nodos y sumo el dato de retardo
        return Math.max(left, right) + arbol.getData();
    }
}
