package Practica3;

import java.util.List;

public class AnalizadorArbol {

    public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol){
        GeneralTree<AreaEmpresa> aux;

        Queue<GeneralTree<AreaEmpresa>> queue = new Queue<>();
        queue.enqueue(arbol);

        int max = -1;

        while (!queue.isEmpty()){
            int size = queue.size(); //cant de nodos en el nivel
            int suma = 0; // sumador de tardanzas en el nivel

            //recorro todos los nodos del nivel
            for (int i = 0; i < size; i++) {
                aux = queue.dequeue();
                suma += aux.getData().getTardanza();

                // encolo los hijos del siguiente nivel
                List<GeneralTree<AreaEmpresa>> children = aux.getChildren();
                for (GeneralTree<AreaEmpresa> child: children){
                    queue.enqueue(child);
                }
            }
            // determino el maximo despues de procesar cada nivel, si la suma no supera el maximo, este se mantiene
            max = Math.max(suma, max);
        }
        return max;
    }

    public static class AreaEmpresa {
        private String id;
        private int tardanza;

        public AreaEmpresa(int tardanza, String id) {
            this.tardanza = tardanza;
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getTardanza() {
            return tardanza;
        }

        public void setTardanza(int tardanza) {
            this.tardanza = tardanza;
        }
    }
}
