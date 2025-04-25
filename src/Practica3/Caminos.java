package Practica3;

import java.util.ArrayList;
import java.util.List;

public class Caminos {
    private GeneralTree<Integer> arbol;

    public Caminos(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public List<Integer> caminoAHojaMasLejana (){
        List<Integer> camino = new ArrayList<>();
        List<Integer> caminoMax = new ArrayList<>();
        if ((this.arbol != null) && (!this.arbol.isEmpty())){
             caminoRecursivo(this.arbol, camino, caminoMax);
        }
        return caminoMax;
    }

    private void caminoRecursivo(GeneralTree<Integer> a, List<Integer> caminoActual, List<Integer> caminoMax){
        caminoActual.add(a.getData());

        if (a.isLeaf())
            if (caminoActual.size() > caminoMax.size()) {
                caminoMax.clear(); // saco los elementos del camino max anterior
                caminoMax.addAll(caminoActual); // actualizo el maximo con el camino actual
            }
        else {
                for (GeneralTree<Integer> child : a.getChildren()) {
                    caminoRecursivo(child, caminoActual, caminoMax);
                }
            }

        // elimino el ultimo nodo agregado al camino para retroceder (backtracking)
        caminoActual.remove(caminoActual.size() - 1);
    }

}


