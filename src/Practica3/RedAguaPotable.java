package Practica3;

import java.util.List;

public class RedAguaPotable {
    private GeneralTree<Character> red;


    public RedAguaPotable(GeneralTree<Character> red) {
        this.red = red;
    }


    public double minimoCaudal(double caudal){
        return calcularMinimo(this.red, caudal);
    }

    private double calcularMinimo(GeneralTree<Character> nodo, double caudalActual){
        if (nodo.isLeaf()) { // es una casa
            return caudalActual;
        }

        int cantHijos = nodo.getChildren().size();
        double nuevoCaudal = caudalActual / cantHijos;
        double min = Double.MAX_VALUE;

        for (GeneralTree<Character> child : nodo.getChildren()) {
            min = Math.min(min, calcularMinimo(child, nuevoCaudal));
        }

        return min;
    }


}

