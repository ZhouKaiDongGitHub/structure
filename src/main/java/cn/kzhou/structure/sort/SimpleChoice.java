package cn.kzhou.structure.sort;

public class SimpleChoice {

    private int[] arr;

    public SimpleChoice(int[] arr){
        this.arr = arr;
    }

    public void sort(){
        long start = System.currentTimeMillis();
        for (int i=0;i<arr.length-1;i++){
            int min = i;
            boolean flag = false;
            for (int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min = j;
                    flag = true;
                }
            }
            if(flag){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
            //System.out.println("第"+(i+1)+"次选择出来的元素为："+ arr[min]+" ，第一次排序后的结果为："+display());

        }
        long spend = System.currentTimeMillis() - start;
        System.out.println("简单选择花费毫秒数： " + spend);
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
