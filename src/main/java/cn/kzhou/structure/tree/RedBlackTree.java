package cn.kzhou.structure.tree;

//https://www.cnblogs.com/skywang12345/p/3624343.html


public class RedBlackTree<E extends Comparable> {

    private TreeNode<E> root;

    public RedBlackTree(){
        root = null;
    }

    /*
     *      px                              px
     *     /                               /
     *    x                               y
     *   /  \      --(左旋)-.           / \
     *  lx   y                          x  ry
     *     /   \                       /  \
     *    ly   ry                     lx  ly
     *
     *
     */
    public void leftRotate(TreeNode<E> x){
        TreeNode<E> y = x.right;

        x.right = y.left;
        if(y.left != null)
            y.left.parent = x;

        y.parent = x.parent;

        if(x.parent == null){
            this.root = y;
        }else {
            if(x.parent.left == x){
                x.parent.left = y;
            }else {
                x.parent.right = y;
            }
        }
        y.left = x;
        x.parent = y;

    }

    /*
     *            py                               py
     *           /                                /
     *          y                                x
     *         /  \      --(右旋)-.            /  \
     *        x   ry                           lx   y
     *       / \                                   / \
     *      lx  rx                                rx  ry
     *
     */
    public void rightRotate(TreeNode<E> y){
         TreeNode<E> x = y.left;

         y.left = x.right;
         if(x.right!=null)
            x.right.parent = y;

         x.parent = y.parent;

         if(y.parent == null){
             this.root = x;
         }else {
             if(y.parent.left == y){
                 y.parent.left = x;
             }else {
                 y.parent.right = x;
             }
         }

         x.right = y;
    }

    public void insert(E element){
        TreeNode<E> node = new TreeNode<>(element,TreeColor.Red);
        insert(node);
    }
    private void insert(TreeNode<E> treeNode){
        TreeNode<E> temp = root;
        TreeNode<E> tempFather = null;
        //找到插入的节点
        while (temp!=null){
            tempFather = temp;
            if(treeNode.element.compareTo(temp.element)<0){
                temp = temp.left;
            }else {
                temp = temp.right;
            }
        }
        treeNode.parent = tempFather;
        if(tempFather!=null){//树不为空
            if(treeNode.element.compareTo(tempFather.element)<0){
                tempFather.left = treeNode;
            }else {
                tempFather.right = treeNode;
            }
        }else {
            //树为空
            this.root = treeNode;
            treeNode.treeColor = TreeColor.Black;
        }

        //修正为平衡树
        insertFixUp(treeNode);
    }

    private void insertFixUp(TreeNode<E> treeNode){
        TreeNode<E> parent,grandparent;
        //如果父节点存在且为红色
        while ( (parent = parentOf(treeNode))!=null  && parent.treeColor.equals(TreeColor.Red)){
            //由于根节点不可能为红色，因此祖父节点必然存在
            grandparent = parentOf(parent);
            //父节点是祖父的左孩子
            if(parent == grandparent.left){
                //Case1: 父亲和叔叔都是红色
                TreeNode<E> uncle = grandparent.right;
                if(uncle!=null && uncle.treeColor.equals(TreeColor.Red)){
                    parent.treeColor = TreeColor.Black;
                    uncle.treeColor = TreeColor.Black;
                    grandparent.treeColor = TreeColor.Red;
                    treeNode = grandparent;
                    continue;
                }
                //Case2: 叔父为黑色，且自己是又孩子，需要先进行一下左旋
                if(parent.right == treeNode){
                    leftRotate(parent);
                    //TreeNode<E> temp = parent;
                }
                //Case3 :叔父为黑色，且自己是左孩子，直接进行又旋
                rightRotate(grandparent);
                parent.treeColor = TreeColor.Black;
                grandparent.treeColor = TreeColor.Red;
            }else {
            //父节点是祖父的右孩子

            }
        }
        //父节点为黑色，无需做任何改变
    }

    private TreeNode<E> parentOf(TreeNode<E> node){
        return node!=null ? node.parent :null;
    }

    private class TreeNode<E extends Comparable>{
        private E element;
        private TreeNode<E> left;
        private TreeNode<E> right;
        private TreeNode<E> parent;
        private TreeColor treeColor;
        public TreeNode(E element,TreeColor treeColor){
            this.element = element;
            this.treeColor = treeColor;
        }

        public TreeNode(E element, TreeNode<E> parent, TreeColor treeColor) {
            this.element = element;
            this.parent = parent;
            this.treeColor = treeColor;
        }

        public TreeNode(E element, TreeNode<E> left, TreeNode<E> right, TreeNode<E> parent, TreeColor treeColor) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.treeColor = treeColor;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "element=" + element +
                    ", treeColor=" + treeColor +
                    '}';
        }
    }
    private  enum  TreeColor{
        Red,
        Black;
    }

    public static void main(String[] args) {
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        redBlackTree.insert(1);
    }
}
