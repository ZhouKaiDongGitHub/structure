package cn.kzhou.structure.sort.advance.exe;

public class HeapSort2 {

    private int[] array;

    public HeapSort2(int[] array){
        this.array = array;
    }

    public void sort(){
        buildHeap();
        int lastIndex = array.length -1;
        while (lastIndex>0){
            swap(0,lastIndex);
            if(--lastIndex ==0){
                break;
            }
            adjustHeap(0,lastIndex);
        }

    }

    /**
     * 由于是完全二叉树，数组本身就可以作为完全二叉树，现在只需要调整堆
     * 由于数组的下标原因，父节点和子节点的下标需要按实际清理去获取
     *         //     0
     *         //    1  2
     *         //  3  4  5  6
     *         // 7
     */
    private void buildHeap(){
        int lastIndex = array.length-1;

        if(lastIndex>0){
            for(int i=(lastIndex-1/2);i>=0;i--){
                adjustHeap(i,lastIndex);
            }
        }
    }

    private void adjustHeap(int i,int lastIndex){
        int biggerIndex = i;
        int leftChild = i*2+1;
        int rightChild = i*2 +2;

        if(rightChild<=lastIndex){
            if(array[i]<array[leftChild] || array[i]<array[rightChild]){ //子节点中存在比根更大的元素
                biggerIndex = array[leftChild]<array[rightChild] ? rightChild :leftChild;
            }
        }else if(leftChild<=lastIndex){  //只存在左子节点

            if(array[leftChild]>array[i]){  //左子节点更大
                biggerIndex = leftChild;
            }
        }
        if(biggerIndex!=i){
            swap(biggerIndex,i);
            adjustHeap(biggerIndex,lastIndex);
        }
    }

    private void swap(int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public String display(){
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<array.length;i++){

            sb.append(array[i] + "\t");
        }
        return sb.toString();
    }
}
