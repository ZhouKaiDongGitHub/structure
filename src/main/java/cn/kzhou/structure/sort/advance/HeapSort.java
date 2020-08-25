package cn.kzhou.structure.sort.advance;

public class HeapSort {

    private int[] array;

    public HeapSort(int[] array){
        this.array = array;
    }

    public void sort(){
        long start = System.currentTimeMillis();

        buildHeap();
        int lastIndex = array.length-1;
        while(lastIndex>0){
            swap(0,lastIndex);  //取出堆顶元素，将堆底放入堆顶。其实就是交换下标为0与lastIndex的数据
            if(--lastIndex == 0) break;  //只有一个元素时就不用调整堆了，排序结束
            adjustHeap(0,lastIndex);  //调整堆
        }

        long spend = System.currentTimeMillis() - start;
        System.out.println("堆排序花费毫秒数： " + spend);
    }
    private void buildHeap(){
        int lastIndex = array.length-1;
        for(int i= (lastIndex-1)/2 ; i>=0 ; i--){
            adjustHeap(i,lastIndex);  //调整以下标i的元素为根的子树
        }
    }

    private void adjustHeap(int rootIndex,int lastIndex){

        int biggerIndex = rootIndex;
        int leftChildIndex = 2*rootIndex+1;
        int rightChildIndex = 2*rootIndex+2;

        if(rightChildIndex<=lastIndex){  //存在右子节点，则必存在左子节点

            if(array[rootIndex]<array[leftChildIndex] || array[rootIndex]<array[rightChildIndex]){ //子节点中存在比根更大的元素
                biggerIndex = array[leftChildIndex]<array[rightChildIndex] ? rightChildIndex :leftChildIndex;
            }

        }else if(leftChildIndex<=lastIndex){  //只存在左子节点

            if(array[leftChildIndex]>array[rootIndex]){  //左子节点更大
                biggerIndex = leftChildIndex;
            }
        }

        if(biggerIndex != rootIndex){  //找到了比根更大的子节点

            swap(rootIndex,biggerIndex);

            //交换位置后可能会破坏子树，将焦点转向交换了位置的子节点，调整以它为根的子树
            adjustHeap(biggerIndex,lastIndex);
        }
    }

    private void swap(int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }


    public int getIndex(int index){
        if(array.length>=index){
            return array[index];
        }
        return -1;
    }
}
