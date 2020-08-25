package cn.kzhou.structure.sort.advance;

public class MergeSort {

    private int[] array;

    public MergeSort(int[] array){
        this.array = array;
    }

    public void sort(){
        long start = System.currentTimeMillis();

        int[] workSpace = new int [array.length]; //用于辅助排序的数组
        recursiveMergeSort(workSpace,0,workSpace.length-1);
        long spend = System.currentTimeMillis() - start;

        System.out.println("归并排序花费毫秒数： " + spend);
    }

    /**
     * 递归的归并排序
     * @param workSpace  辅助排序的数组
     * @param lowerBound 欲归并数组段的最小下标
     * @param upperBound 欲归并数组段的最大下标
     */
    private void recursiveMergeSort(int [] workSpace,int lowerBound,int upperBound){

        if(lowerBound== upperBound){  //该段只有一个元素，不用排序
            return;
        }else{
            int mid = (lowerBound+upperBound)/2;
            recursiveMergeSort(workSpace,lowerBound,mid);    //对低位段归并排序
            recursiveMergeSort(workSpace,mid+1,upperBound);  //对高位段归并排序
            merge(workSpace,lowerBound,mid,upperBound);
        }
    }

    /**
     * 对数组array中的两段进行合并，lowerBound~mid为低位段，mid+1~upperBound为高位段
     * @param workSpace 辅助归并的数组，容纳归并后的元素
     * @param lowerBound 合并段的起始下标
     * @param mid 合并段的中点下标
     * @param upperBound 合并段的结束下标
     */
    private void merge(int [] workSpace,int lowerBound,int mid,int upperBound){

        int lowBegin = lowerBound;  //低位段的起始下标
        int lowEnd = mid;           //低位段的结束下标
        int highBegin = mid+1;  //高位段的起始下标
        int highEnd = upperBound;  //高位段的结束下标
        int j = 0; //workSpace的下标指针
        int n = upperBound-lowerBound+1;  //归并的元素总数

        while(lowBegin<=lowEnd && highBegin<=highEnd){
            if(array[lowBegin]<array[highBegin]){//将两者较小的那个放到workSpace中
                workSpace[j++]= array[lowBegin++];
            }else{
                workSpace[j++]= array[highBegin++];
            }
        }

        while(lowBegin<=lowEnd){
            workSpace[j++]= array[lowBegin++];
        }

        while(highBegin<=highEnd){
            workSpace[j++]= array[highBegin++];
        }

        for(j=0;j<n;j++){  //将归并好的元素复制到array中
            array[lowerBound++]= workSpace[j];
        }

    }



    public static void merge(int [] arrayA,int sizeA,
                             int [] arrayB,int sizeB,
                             int [] arrayC){

        int i=0,j=0,k=0;  //分别当作arrayA、arrayB、arrayC的下标指针

        while(i<sizeA && j<sizeB){  //两个数组都不为空
            if(arrayA[i]<arrayB[j]){//将两者较小的那个放到arrayC中
                arrayC[k++]= arrayA[i++];
            }else{
                arrayC[k++]= arrayB[j++];
            }
        }  //该循环结束后，一个数组已经完全复制到arrayC中了，另一个数组中还有元素

        //后面的两个while循环用于处理另一个不为空的数组
        while(i<sizeA){
            arrayC[k++]= arrayA[i++];
        }

        while(j<sizeB){
            arrayC[k++]= arrayA[j++];
        }
    }

    public int getIndex(int index){
        if(array.length>=index){
            return array[index];
        }
        return -1;
    }
}
