package cn.kzhou.structure.sort.advance.exe;

public class QuickSort2 {

    private int[] array;

    public QuickSort2(int[] array){
        this.array = array;
    }

    public void sort(){
        recusiveSort(0,array.length-1);
    }

    private void recusiveSort(int left,int right){
        if(left>right){
            return;
        }
        int index = getIndex(left,right);
        recusiveSort(left,index-1);
        recusiveSort(index+1,right);
    }

    private int getIndex(int left,int right){
        int temp = array[left];
        while (left<right){
            while (left<right && array[right]>=temp){
                right --;
            }
            swap(left,right);
            while (left<right && array[left] <= temp){
                left ++ ;
            }
            swap(left,right);
        }
        return left;
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
