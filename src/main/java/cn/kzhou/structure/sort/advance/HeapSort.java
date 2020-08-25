package cn.kzhou.structure.sort.advance;

public class HeapSort {

    private int[] array;

    public HeapSort(int[] array){
        this.array = array;
    }

    public void sort(){
        long start = System.currentTimeMillis();
        buildHeap();
        //System.out.println("建堆：");
        //printTree(array.length);

        int lastIndex = array.length-1;
        while(lastIndex>0){
            swap(0,lastIndex);  //取出堆顶元素，将堆底放入堆顶。其实就是交换下标为0与lastIndex的数据
            if(--lastIndex == 0) break;  //只有一个元素时就不用调整堆了，排序结束
            adjustHeap(0,lastIndex);  //调整堆

            //System.out.println("调整堆：");
            //printTree(lastIndex+1);
        }

        long spend = System.currentTimeMillis() - start;
        System.out.println("堆排序花费毫秒数： " + spend);
    }
    private void buildHeap(){
        int lastIndex = array.length-1;
        // (lastIndex-1)/2 就是最后一个元素的根节点的下标，依次调整每棵子树
        //这一步就已经可能省去了一半元素的比较了，在大数据情况下，优势立显
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

    /**
     * 将数组按照完全二叉树的形式打印出来
     */
    private void printTree(int len){

        int layers = (int)Math.floor(Math.log((double)len)/Math.log((double)2))+1;  //树的层数
        int maxWidth = (int)Math.pow(2,layers)-1;  //树的最大宽度
        int endSpacing = maxWidth;
        int spacing;
        int numberOfThisLayer;
        for(int i=1;i<=layers;i++){  //从第一层开始，逐层打印
            endSpacing = endSpacing/2;  //每层打印之前需要打印的空格数
            spacing = 2*endSpacing+1;  //元素之间应该打印的空格数
            numberOfThisLayer = (int)Math.pow(2, i-1);  //该层要打印的元素总数

            int j;
            for(j=0;j<endSpacing;j++){
                System.out.print("  ");
            }

            int beginIndex = (int)Math.pow(2,i-1)-1;  //该层第一个元素对应的数组下标
            for(j=1;j<=numberOfThisLayer;j++){
                System.out.print(array[beginIndex++]+"");
                for(int k=0;k<spacing;k++){  //打印元素之间的空格
                    System.out.print("  ");
                }
                if(beginIndex == len){  //已打印到最后一个元素
                    break;
                }
            }

            System.out.println();
        }
        System.out.println();
    }

    public int getIndex(int index){
        if(array.length>=index){
            return array[index];
        }
        return -1;
    }
}
