package cn.kzhou.structure.tree;

public class Node<E extends Comparable> {
    private E element;
    public Node leftChild;
    public Node rightChild;

    public Node() {
    }

    public Node(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                '}';
    }
}
