package Practica3;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}

	public void preOrder(){
		System.out.println(getData());
		List<GeneralTree<T>> children = this.getChildren();
		for (GeneralTree<T> child: children) {
			child.preOrder();
		}
	}

	public void postOrder(){
		List<GeneralTree<T>> children = this.getChildren();
		for (GeneralTree<T> child: children) {
			child.postOrder();
		}
		System.out.println(getData());
	}

	public void porNiveles (){
		GeneralTree<T> aux;

		Queue<GeneralTree<T>> queue = new Queue<>();
		queue.enqueue(this);

		while (!queue.isEmpty()) {
			int size = queue.size(); // cantidad de nodos en este nivel

			// Imprimir todos los nodos de este nivel
			for (int i = 0; i < size; i++) {
				aux = queue.dequeue();
				System.out.print(aux.getData() + " ");

				//Encolo los hijos del nodo actual para el siguiente nivel
				for (GeneralTree<T> child : aux.getChildren()) {
					queue.enqueue(child);
				}
			}
			System.out.println(); // salto de línea entre niveles
		}
	}

	//devuelve la altura del árbol, es decir, la longitud del camino más largo
	//desde el nodo raíz hasta una hoja.
	public int altura() {
		if (this.hasChildren()) {
			int max = -1;

			List<GeneralTree<T>> children = this.getChildren();
			for (GeneralTree<T> child: children)
				max = Math.max(child.altura(), max);

			return max + 1;
		}
		return 0;
	}

	//devuelve la profundidad o nivel del dato en el árbol. El nivel de un nodo
	//es la longitud del único camino de la raíz al nodo.
	public int nivel(T dato){
		if (!this.isEmpty())
			return -1;
		return nivelRecursivo(this, dato, 0);
	}

	private int nivelRecursivo(GeneralTree<T> a, T dato, int nivel) {
		if (a.getData().equals(dato)) {
			return nivel;  // Si encuentro el dato en el nodo actual, devuelvo el nivel
		}

		List<GeneralTree<T>> children = a.getChildren();
		for (GeneralTree<T> child : children) {
			int nivelHijo = nivelRecursivo(child, dato, nivel + 1);  // Aumento el nivel al buscar en los hijos
			if (nivelHijo != -1) {
				return nivelHijo;  // Si encontré el dato en un hijo, devuelvo su nivel
			}
		}

		return -1;  // Si no se encontró el dato en el árbol
	}

	// la amplitud (ancho) de un árbol se define como la cantidad de nodos que
	// se encuentran en el nivel que posee la mayor cantidad de nodos.
	public int ancho(){
		GeneralTree<T> aux;

		Queue<GeneralTree<T>> queue = new Queue<>();
		queue.enqueue(this);
		int max = 0;

		while (!queue.isEmpty()) {
			int size = queue.size(); // cantidad de nodos en este nivel
			max = Math.max(size, max); // si el nivel actual supera el maximo se actualiza sino se mantiene

			for (int i = 0; i < size; i++) {
				aux = queue.dequeue();

				//Encolo los hijos del nodo actual para el siguiente nivel
				for (GeneralTree<T> child : aux.getChildren()) {
					queue.enqueue(child);
				}
			}
		}
        return max;
    }

	// devuelve true si el valor “a” es ancestro del valor “b”
	public boolean esAncestro(T a, T b){
		boolean encontre = false;

		if (!this.isEmpty()) {
			GeneralTree<T> nodoA = buscarNodo(this, a);

			//Si encontro "a", entonces busco "b" en subarbol de "a"
			if (nodoA != null) {
				GeneralTree<T> nodoB = buscarNodo(nodoA, b);

				// si encontro "b" entonces es ancestro al estar en subarbol de "a"
				if (nodoB != null) encontre = true;
			}
		}
		return encontre;
	}

	private GeneralTree<T> buscarNodo(GeneralTree<T> a, T dato){
		if (a.getData().equals(dato))
			return a;

		List<GeneralTree<T>> children = a.getChildren();
		for (GeneralTree<T> child: children){
			GeneralTree<T> nodo = buscarNodo(child, dato);

			if (nodo != null)
				return nodo;
		}
		return null;
	}

}