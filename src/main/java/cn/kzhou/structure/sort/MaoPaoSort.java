package cn.kzhou.structure.sort;

public class MaoPaoSort {

    private int[] arr;

    public MaoPaoSort(int[] arr){
        this.arr = arr;
    }

    public void sort(){
        long start = System.currentTimeMillis();
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            //System.out.println("第"+(i+1)+"轮排序的结果为 : " +display());
        }
        long spend = System.currentTimeMillis() - start;
        System.out.println("冒泡花费毫秒数： " + spend);
    }

    private String display(){
        StringBuffer sb = new StringBuffer();
        for (int element:arr
             ) {
            sb.append(element+" , ");
        }
        return sb.toString();
    }

    public int getIndex(int index){
        if(arr.length>=index){
            return arr[index];
        }
        return -1;
    }
}
