package cn.kzhou.structure.tree;

public class BinaryTree {

    private Node root;

    //添加
    public void addNode(Node node){
        if(node.getStudentNumber() == null){
            System.out.println("StudentNumber cannot be null");
            return;
        }
        //树为空
        if(root == null){
            root = node;
            return;
        }
        Node currentNode ;
        Node nextNode  = root;
        Boolean isLeft = true;
        do{
            currentNode = nextNode;
            if(node.getStudentNumber()<nextNode.getStudentNumber()){
                nextNode = currentNode.left;
                isLeft = true;
            }else if(node.getStudentNumber()> nextNode.getStudentNumber()){
                nextNode = currentNode.rigth;
                isLeft = false;
            }
        }while (nextNode != null);

        if(isLeft){
            currentNode.left = node;
        }else {
            currentNode.rigth = node;
        }
    }

    public Node deleteNode(Node node){
        //删除节点有三种情况
        //1.删除的节点没有子节点

        //2.删除的节点只有一个子节点
        //3.删除的节点有两个子节点
    }

    public boolean modifyNode(Node node){
        Node temp;
        if((temp=findNode(node))!=null){
            temp.setName(node.getName());
            temp.setAge(node.getAge());
            return true;
        }
        return false;
    }

    public Node findNode(Node node){
        Node temp = root;
        while (temp!=null && node.getStudentNumber() != temp.getStudentNumber()){
            if(node.getStudentNumber()< temp.getStudentNumber()){
                temp = temp.left;
            }else {
                temp = temp.rigth;
            }
        }
        if(temp == null){
            System.out.println("未找到需要的值！");
            return null;
        }
        return temp;
    }

    public void traverseTreeLeft(){
        //左序遍历
        if(root == null){
            System.out.println("The tree is null");
            return;
        }
        traverseTree(root);
    }

    public void traverseTree(Node node){
        if(node.left != null){
            traverseTree(node.left);
        }
        System.out.println(node);
        if(node.rigth != null){
            traverseTree(node.rigth);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(new Node(null,"zhangsan",25));
        binaryTree.addNode(new Node(1,"zhangsan",25));
        binaryTree.addNode(new Node(5,"lisi",55));
        binaryTree.addNode(new Node(10,"wangwu",26));
        binaryTree.addNode(new Node(2,"zhaoliu",18));
        binaryTree.addNode(new Node(3,"liuqi",60));
        binaryTree.addNode(new Node(7,"zhuba",11));
        binaryTree.traverseTreeLeft();


    }
}
