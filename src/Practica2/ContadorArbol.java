package Practica2;

import java.util.ArrayList;
import java.util.List;

public class ContadorArbol {
    private BinaryTree<Integer> a;

    public ContadorArbol() {
        this.a = new BinaryTree<>();
    }

    private boolean isEven (Integer num){
        return num % 2 == 0;
    }

    public List<Integer> evenNumbersInOrden() {
        List<Integer> list = new ArrayList<>();
        this.evenNumbersInOrden(a, list);
        return list;
    }

    private void evenNumbersInOrden(BinaryTree<Integer> arbol, List<Integer> list){
        if (arbol.hasLeftChild())
            evenNumbersInOrden(arbol.getLeftChild(), list);

        if (!arbol.isEmpty())
            if (isEven(arbol.getData()))
                list.add(arbol.getData());

        if (arbol.hasRightChild())
            evenNumbersInOrden(arbol.getRightChild(), list);
    }

    public List<Integer> evenNumbersPostOrden() {
        List<Integer> list = new ArrayList<>();
        this.evenNumbersPostOrden(a, list);
        return list;
    }

    private void evenNumbersPostOrden(BinaryTree<Integer> arbol, List<Integer> list){
        if (arbol.hasLeftChild())
            evenNumbersInOrden(arbol.getLeftChild(), list);

        if (arbol.hasRightChild())
            evenNumbersInOrden(arbol.getRightChild(), list);

        if (!arbol.isEmpty())
            if (isEven(arbol.getData()))
                list.add(arbol.getData());
    }
}
