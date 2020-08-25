package cn.kzhou.structure.sort.advance;

public class QuickSort {

    private int[] arr;

    public QuickSort(int[] arr){
        this.arr = arr;
    }

    public void sort(){
        long start = System.currentTimeMillis();

        recursiveSort(0,arr.length-1);

        long spend = System.currentTimeMillis() - start;
        System.out.println("快速排序花费毫秒数： " + spend);
    }

    private void recursiveSort(int left,int right){
        if(left>=right){
            return;
        }else {
            int base = arr[left];
            int index = partition(left,right,base);
            recursiveSort(left,index-1);
            recursiveSort(index+1,right);
        }
    }

    private int partition(int left,int right,int base){
        while (left<right){
            while (left<right && arr[right]>=base){
                right--;
            }
            swap(left,right);
            while (left<right && arr[left]<=base){
                left++;
            }
            swap(left,right);
        }
        return left;
    }

    private void swap(int low,int high){
        int temp = arr[high];
        arr[high] = arr[low];
        arr[low] = temp;
    }

    public int getIndex(int index){
        if(arr.length>=index){
            return arr[index];
        }
        return -1;
    }
}
