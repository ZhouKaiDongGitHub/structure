package cn.kzhou.structure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BinaryTree<E extends Comparable> {

    private Node<E> root;

    BinaryTree(){
        root = null;
    }

    public void insert(E element){
        if(root == null){
           root = new Node<>(element);
           return;
        }
        Node<E> temp = root;
        while (true){
            if(element.compareTo(temp.getElement())<0){
                if(temp.leftChild == null){
                    temp.leftChild = new Node(element);
                    return;
                }
                temp = temp.leftChild;
            }else {
                if(temp.rightChild == null){
                    temp.rightChild = new Node(element);
                    return;
                }
                temp = temp.rightChild;
            }
        }
    }

    public Node delete(E element){
        //删除节点有三种情况
        if(root == null){
            return null;
        }
        Node<E> temp = root;
        Node<E> tempFather = null;
        boolean isLeft = true;
        while (element.compareTo(temp.getElement())!= 0){
            tempFather = temp;
            if(element.compareTo(temp.getElement())<0){
                temp = temp.rightChild;
                isLeft = false;
            }else if(element.compareTo(temp.getElement())<0){
                temp = temp.leftChild;
                isLeft = true;
            }
            if(temp == null){
                return null;
            }
        }
        //1.删除的节点没有子节点
        if(temp.leftChild == null && temp.rightChild ==null){
            if(temp == root){
                root = null;
            }else if(isLeft){
                tempFather.leftChild = null;
            }else {
                tempFather.rightChild = null;
            }
            //2.删除的节点只有一个子节点
        }else if(temp.leftChild == null){
            if(temp == root){
                root = temp.rightChild;
            }else if(isLeft){
                tempFather.leftChild = temp.rightChild;
            }else{
                tempFather.rightChild = temp.rightChild;
            }
        }else if(temp.rightChild == null){
            if(temp == root){
                root = temp.leftChild;
            }else if(isLeft){
                tempFather.leftChild = temp.leftChild;
            }else{
                tempFather.rightChild = temp.leftChild;
            }
        }else {
            //3.删除的节点有两个子节点
            //找出后继节点
            Node<E> success = temp.rightChild;
            Node<E> successFather = null;
            while (success.leftChild != null){
                successFather = success;
                success = success.leftChild;
            }
            if(successFather == null){//后继节点就是要删除节点的右孩子
                success.leftChild = temp.leftChild;
                if(temp ==root){
                    root = success;
                }else  if(isLeft){
                    tempFather.leftChild = success;

                }else {
                    tempFather.rightChild = success;
                }
            }else {//后继节点是要删除节点的左下角节点
                successFather.leftChild = success.rightChild;
                success.leftChild = temp.leftChild;
                if(temp == root){
                    root = success;
                }else if(isLeft){
                    tempFather.leftChild = success;
                }else {
                    tempFather.rightChild = success;
                }
            }
        }
        return temp;
    }

    public Node<E> getMax(){
        if(root == null){
            return null;
        }else {
            Node<E> temp = root;
            while (true){
                if(temp.rightChild == null){
                    return temp;
                }else {
                    temp = temp.rightChild;
                }
            }
        }
    }

    public Node<E> getMin(){
        if(root == null){
            return null;
        }else {
            Node<E> temp = root;
            while (true){
                if(temp.leftChild==null){
                    return temp;
                }else {
                    temp = temp.leftChild;
                }
            }
        }
    }

    public Node findNode(E element){
        Node temp = root;
        if(root == null){
            return null;
        }
        while (element.compareTo(temp.getElement())!=0){
            if(element.compareTo(temp.getElement())<0){
                temp = temp.leftChild;
            }else {
                temp = temp.rightChild;
            }
            if(temp == null){
                return null;
            }
        }
        return temp;
    }

    //以树的形式打印出该树
    public void displayTree(){
        int depth = getTreeDepth();
        ArrayList<Node> currentLayerNodes = new ArrayList<Node>();
        currentLayerNodes.add(root);  //存储该层所有节点
        int layerIndex = 1;
        while(layerIndex <= depth){
            int NodeBlankNum = (int)Math.pow(2, depth-layerIndex)-1;  //在节点之前和之后应该打印几个空位
            for(int i = 0;i<currentLayerNodes.size();i++){
                Node node = currentLayerNodes.get(i);
                printBlank(NodeBlankNum);   //打印节点之前的空位

                if(node == null){
                    System.out.print("*\t");  //如果该节点为null，用空位代替
                }else{
                    System.out.print("*  "+node.getElement()+"\t");  //打印该节点
                }

                printBlank(NodeBlankNum);  //打印节点之后的空位
                System.out.print("*\t");   //补齐空位
            }
            System.out.println();
            layerIndex++;
            currentLayerNodes = getAllNodeOfThisLayer(currentLayerNodes);  //获取下一层所有的节点
        }
    }

    //获取指定节点集合的所有子节点
    private ArrayList getAllNodeOfThisLayer(List parentNodes){
        ArrayList list = new ArrayList<Node>();
        Node parentNode;
        for(int i=0;i<parentNodes.size();i++){
            parentNode = (Node)parentNodes.get(i);
            if(parentNode != null){
                if(parentNode.leftChild != null){  //如果上层的父节点存在左子节点，加入集合
                    list.add(parentNode.leftChild);
                }else{
                    list.add(null);  //如果上层的父节点不存在左子节点，用null代替，一样加入集合
                }
                if(parentNode.rightChild != null){
                    list.add(parentNode.rightChild);
                }else{
                    list.add(null);
                }
            }else{  //如果上层父节点不存在，用两个null占位，代表左右子节点
                list.add(null);
                list.add(null);
            }
        }
        return list;
    }

    //打印指定位数的*
    private void printBlank(int number){
        for (int i=0;i<number;i++){
            System.out.print("*\t");
        }
    }

    public static final int PREORDER = 1;
    public static final int INORDER = 2;
    public static final int POSTORDER = 3;

    public void traverse(int type){
        switch (type){
            case 1:
                System.out.println("先序遍历： \t");
                preorder(root);
                break;
            case 2:
                System.out.println("中序遍历： \t");
                inorder(root);
                break;
            case 3:
                System.out.println("后序遍历： \t");
                postorder(root);
                break;
        }
    }

    private void inorder(Node<E> node){
        if(node != null){
            inorder(node.leftChild);
            System.out.println(node.toString());
            inorder(node.rightChild);
        }
    }

    private void postorder(Node<E> node){
        if(node != null){
            System.out.println(node.toString());
            preorder(node.leftChild);
            preorder(node.rightChild);
        }
    }
    private void preorder(Node<E> node){
        if(node != null){
            preorder(node.leftChild);
            preorder(node.rightChild);
            System.out.println(node.toString());
        }
    }

    public int getTreeDepth(){
        if(root == null){
            return 0;
        }
        return getDepth(root,1);
    }

    private int getDepth(Node<E> node,int depth){
        int leftDepth = depth;
        int rightDepth = depth;
        if(node.leftChild!=null){
            leftDepth = getDepth(node.leftChild,leftDepth +1);
        }
        if(node.rightChild!=null){
            rightDepth = getDepth(node.rightChild,rightDepth+1);
        }
        return Math.max(leftDepth,rightDepth);
    }

    //判断是否为叶子节点
    public boolean isLeaf(Node node){
        return (node.leftChild != null || node.rightChild != null);
    }

    //获取根节点
    public Node getRoot(){
        return root;
    }


    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.insert(3);
        binaryTree.insert(1);
        binaryTree.insert(4);
        binaryTree.insert(10);
        binaryTree.insert(9);
        binaryTree.insert(2);
        binaryTree.insert(8);
        binaryTree.insert(12);
        binaryTree.insert(20);
        binaryTree.insert(18);
        binaryTree.displayTree();
        binaryTree.traverse(2);
        binaryTree.delete(3);
        binaryTree.displayTree();
        binaryTree.traverse(2);

    }
}
