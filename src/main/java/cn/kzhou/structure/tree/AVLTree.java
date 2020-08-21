package cn.kzhou.structure.tree;


public class AVLTree<E extends Comparable> {

    private Node<E> root;

    public AVLTree(){
        root = null;
    }
    //AVLTree insert recommand use Recall function
    public void insert(E element){
        if(root == null){
            root = new Node<>(element);
            return;
        }
        root = insert(root,element);
    }
    public Node<E> insert(Node<E> node,E element){
        if(node == null){
            return new Node<>(element);
        }
        Node<E> temp = node;
        if(element.compareTo(temp.getElement())<0){
            temp.leftChild = insert(temp.leftChild,element);
            if(unBlanceTree(temp)){
                if(element.compareTo(temp.leftChild.getElement())<0){
                    //LL
                    temp = LLRotation(temp);
                }else {
                    //LR
                    temp = LRRotation(temp);
                }
            }
        }else if(element.compareTo(temp.getElement())>0){
            temp.rightChild = insert(temp.rightChild,element);
            if(unBlanceTree(temp)){
                if(element.compareTo(temp.rightChild.getElement())<0){
                    //RL
                    temp = RLRotation(temp);
                }else {
                    //RR
                    temp = RRRotation(temp);
                }
            }
        }else {
            System.out.println();
            new Exception("AVL Tree Insert value cannot be same! ");
        }
        return temp;
    }

    private Node<E> LLRotation(Node<E> k1){
        Node<E> k2 = k1.leftChild;
        k1.leftChild = k2.rightChild;
        k2.rightChild = k1;
        return k2;
    }
    private Node<E> LRRotation(Node<E> k1){
        k1.leftChild = RRRotation(k1.leftChild);
        return LLRotation(k1);
    }
    private Node<E> RLRotation(Node<E> k1){
        k1.rightChild = LLRotation(k1.rightChild);
        return LLRotation(k1);
    }
    private Node<E> RRRotation(Node<E> k1){
        Node<E> k2 = k1.rightChild;
        k1.rightChild = k2.leftChild;
        k2.leftChild = k1;
        return k2;
    }
    private boolean unBlanceTree(Node<E> node){
       return Math.abs(getTreeDepth(node.leftChild)-getTreeDepth(node.rightChild))> 1;
    }

    public int getTreeDepth(Node<E> node){
        if(node == null){
            return 0;
        }
        return getDepth(node,1);
    }

    private int getDepth(Node<E> node,int depth){
        int leftDepth = depth;
        int rigthDepth = depth;
        if(node.leftChild != null){
            leftDepth = getDepth(node.leftChild,leftDepth+1);
        }
        if(node.rightChild !=null){
            rigthDepth = getDepth(node.rightChild,rigthDepth+1);
        }
        return Math.max(leftDepth,rigthDepth);
    }

    //delete
    public Node<E> deleteNode(E element){
        if(root == null){
            return null;
        }
        return null;
    }


    public void remove(E element) {
        root = remove(root, element);
    }


    private Node<E>  remove(Node<E> tree, E element) {
        if (tree == null) {
            return tree;
        }

        if (element.compareTo(tree.getElement())<0) { //要删除的节点在左子树

            tree.leftChild = remove(tree.leftChild,element);

        } else if (element.compareTo(tree.getElement())>0){  //要删除的节点在右子树

            tree.rightChild = remove(tree.rightChild, element);

        } else if (element.compareTo(tree.getElement())==0) {  //要删除的节点就是本身

            if (tree.leftChild != null && tree.rightChild != null) { // 左右子树都存在

                if (getDepth(tree.leftChild, 1) > getDepth(tree.rightChild, 1)) {
                    /*
                     * 如果tree的左子树比右子树高:
                     * 1. 找出tree的左子树中的最大节点
                     * 2. 将该最大节点的值赋值给tree。
                     * 3. 删除该最大节点。
                     * 这类似于用"tree的左子树中最大节点"做"tree"的替身
                     * 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的
                     */
                    Node<E> max = getMaxNode(tree.leftChild);
                    tree.setElement(max.getElement());
                    tree.leftChild = remove(tree.leftChild, max.getElement());
                } else {
                    /**
                     * 如果tree的左子树不高于右子树:
                     * 1. 找出tree的右子树中的最小节点
                     * 2. 将该最小节点的值赋值给tree。
                     * 3. 删除该最小节点。
                     * 这类似于用"tree的右子树中最小节点"做"tree"的替身
                     * 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的
                     */
                    Node<E> min = getMinNode(tree.rightChild);
                    tree.setElement(min.getElement()) ;
                    tree.rightChild = remove(tree.rightChild, min.getElement());

                }

            } else {

                tree = tree.leftChild == null ? tree.rightChild : tree.leftChild;

            }
        } else {
            System.out.println("no node matched value: " + element);
        }

        return tree;
    }

    private Node<E> getMaxNode(Node<E> node) {
        if (node == null) {
            return null;
        }

        if (node.rightChild != null) {
            return getMaxNode(node.rightChild);
        } else {
            return node;
        }
    }

    private Node<E> getMinNode(Node<E> node) {
        if (node == null) {
            return null;
        }

        if (node.leftChild != null) {
            return getMinNode(node.leftChild);
        } else {
            return node;
        }
    }

    //findNode
    public Node<E> findNode(E element){
        if(root == null){
            return null;
        }
        Node<E> temp = root;
        while (element.compareTo(temp.getElement())!=0){
            if(element.compareTo(temp.getElement())<0){
                temp = temp.leftChild;
            }else {
                temp = temp.rightChild;
            }
            if(temp==null){
                return null;
            }
        }
        return temp;
    }
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
        System.out.println(avlTree.getTreeDepth(avlTree.root));
        System.out.println(avlTree.findNode(10));
        System.out.println(avlTree.findNode(5));
        //
        System.out.println("删除前树的结构");
        System.out.println("左树的深度："+ avlTree.getTreeDepth(avlTree.root.leftChild));
        System.out.println("右树的深度："+ avlTree.getTreeDepth(avlTree.root.rightChild));
        avlTree.remove(1);
        System.out.println("删除后树的结构");
        System.out.println("左树的深度："+ avlTree.getTreeDepth(avlTree.root.leftChild));
        System.out.println("右树的深度："+ avlTree.getTreeDepth(avlTree.root.rightChild));
    }
}
