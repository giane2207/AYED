package Practica1;

public class Ejercicio1 {
    public static void imprimirConFor(int numA, int numB){
        System.out.println("Con FOR:");
        for(int i=numA; i<= numB; i++){
            System.out.println("Numero: " + i);
        }
    }

    public static void imprimirConWhile(int numA, int numB){
        System.out.println("Con WHILE:");
        while(numA <= numB){
            System.out.println("Numero: " + numA);
            numA++;
        }

    }

    //Utilizo un metodo recursivo para no usar estructuras de control iterativas
    public static void imprimirSinIterador(int numA, int numB){
        //Cuando numA supera a numB se termina la recursion
        if (numA > numB) {return;}

        //Imprimo el numero actual
        System.out.println("Numero: " + numA);

        //Llamo recursivamente incrementando mi numero actual
        imprimirSinIterador(numA + 1, numB);
    }

    public static void main(String[] args) {
        int numA = 10;
        int numB = 20;
        imprimirConFor(numA, numB);
        imprimirConWhile(numA, numB);
        System.out.println("Sin Iterador:");
        imprimirSinIterador(numA, numB);
    }
}
