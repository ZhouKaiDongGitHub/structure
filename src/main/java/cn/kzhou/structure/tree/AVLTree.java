package cn.kzhou.structure.tree;


public class AVLTree<E extends Comparable> {

    private Node<E> root;

    public AVLTree(){
        root = null;
    }
    //insert
    public void insert(E element){
        if(root == null){
            root = new Node<>(element);
            return;
        }
        Node<E> temp = root;
        while (true){
            if(temp.getElement().compareTo(element)>0){
                if(temp.leftChild==null){
                    temp.leftChild = new Node(element);
                    break;
                }else {
                    temp = temp.leftChild;
                }
            }else {
                if(temp.rightChild==null){
                    temp.rightChild = new Node(element);
                    break;
                }else {
                    temp = temp.rightChild;
                }
            }
        }
    }
    //delete
    //findNode
    //reverse

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(4);
        binaryTree.insert(5);
        binaryTree.insert(6);
        System.out.println(binaryTree.getTreeDepth());

        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.insert(6);
    }
}
