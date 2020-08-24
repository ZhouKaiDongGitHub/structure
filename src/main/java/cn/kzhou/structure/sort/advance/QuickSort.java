package cn.kzhou.structure.sort.advance;

public class QuickSort {

    private int[] arr;

    public QuickSort(int[] arr){
        this.arr = arr;
    }

    public void sort(){
        int index = 0;
        for (int i=arr.length-1;i>0;i++){
            if(arr[i]<arr[0]){
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                index = i;
            }
            if(arr[i]>arr[0])
        }
    }

    private void reverseSort(int left,int right){

    }
}
