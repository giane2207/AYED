package Practica2;

public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;


    public BinaryTree() {
        super();
    }

    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * Preguntar antes de invocar si hasLeftChild()
     * @return
     */
    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }
    /**
     * Preguntar antes de invocar si hasRightChild()
     * @return
     */
    public BinaryTree<T> getRightChild() {
        return this.rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty(){
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());

    }

    public boolean hasLeftChild() {
        return this.leftChild!=null;
    }

    public boolean hasRightChild() {
        return this.rightChild!=null;
    }
    @Override
    public String toString() {
        return this.getData().toString();
    }

    public int contarHojas(){
        if (this.isLeaf())
            return 1;
        int suma = 0;
        if (this.hasLeftChild())
            suma += this.getLeftChild().contarHojas();
        if (this.hasRightChild())
            suma += this.getRightChild().contarHojas();
        return suma;
    }

    public BinaryTree<T> espejo(){
        //Hago un arbol auxiliar para no perder los datos
        BinaryTree<T> a = new BinaryTree<T>();

        if(!this.isEmpty())
            a.setData(this.getData());

        if (this.hasLeftChild())
            a.addRightChild(this.getLeftChild().espejo());
        if (this.hasRightChild())
            a.addLeftChild(this.getRightChild().espejo());

        return a;
    }

    // 0<=n<=m
    public void entreNiveles(int n, int m){
        BinaryTree<T> ab = null;

        Queue<BinaryTree<T>> queue = new Queue<BinaryTree<T>>();
        queue.enqueue(this);

        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();

            while (size != 0) {
                ab = queue.dequeue();

                //Si estoy en el rango de niveles: imprimo
                if (n <= level && level <= m)
                    System.out.print(ab + " ");

                if (ab.hasLeftChild())
                    queue.enqueue(ab.getLeftChild());

                if (ab.hasRightChild())
                    queue.enqueue(ab.getRightChild());

                size--;
            }

            //Salto de línea para identificar cambios de nivel
            if (n <= level && level <= m)
                System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
        BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
        hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
        hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
        BinaryTree<Integer> hijoDerecho= new BinaryTree<Integer>(78);
        ab.addLeftChild(hijoIzquierdo);
        ab.addRightChild(hijoDerecho);

        ab.entreNiveles(1,3);
    }
}
