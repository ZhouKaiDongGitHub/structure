package cn.kzhou.structure.sort.advance.exe;

public class QuickSort2 {

    private int[] arr;

    public QuickSort2(int[] arr){
        this.arr = arr;
    }


    public int getIndex(int index){
        if(arr.length>=index){
            return arr[index];
        }
        return -1;
    }
}
