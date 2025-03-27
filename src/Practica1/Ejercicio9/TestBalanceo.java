package Practica1.Ejercicio9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestBalanceo {
    private static List<Character> aperturas;
    private static List<Character> cierres;


    private static boolean esPar(int num){
        return num % 2 == 0;
    }

    public static boolean estaBalanceada(String str) {
        Stack<Character> stack = new Stack<>();
        boolean balanceada = true;

        if (str.isEmpty() || !esPar(str.length()) || cierres.contains(str.charAt(0))) {
            return false;
        }

        for (int i = 0; i < str.length() && balanceada; i++) {  // Se ejecuta mientras balanceada sea true
            char c = str.charAt(i);
            if (aperturas.contains(c)) {
                stack.push(c);
            } else if (cierres.contains(c)) {
                if (stack.isEmpty()) {
                    balanceada = false;  // Si la pila está vacía, no se puede hacer pop()
                } else {
                    char elem = stack.pop();
                    if (!hayPareja(elem, c)) {
                        balanceada = false;
                    }
                }
            }
        }

        if (!stack.isEmpty()) balanceada = false;  // Si quedan elementos en la pila, el string no está balanceado

        return balanceada;
    }

    private static boolean hayPareja (char apertura, char cierre){
        return aperturas.indexOf((apertura)) == cierres.indexOf(cierre);
    }

    public static void main(String[] args) {
        aperturas = new ArrayList<>();
        cierres = new ArrayList<>();
        aperturas.add('('); aperturas.add('['); aperturas.add('{');
        cierres.add(')'); cierres.add(']'); cierres.add('}');

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese cadena para saber si esta balanceada");
        String s = sc.nextLine();
        sc.close();

        if (estaBalanceada(s)) {
            System.out.println("La cadena esta balanceada");
        } else
            System.out.println("La cadena no esta balanceada");
    }

}
