package cn.kzhou.structure.sort;

public class DirectInsert {

    private int[] arr;

    public DirectInsert(int[] arr){
        this.arr = arr;
    }

    /**
     * 插入排序：进行n轮次，每次将数组中的一个元素插入到这个元素之前已经拍好的元素数组之中。
     *          核心思想是找到之前已经排序好的数组的合适插入位置
     */
    public void sort(){
        long start = System.currentTimeMillis();
        for(int i=1;i<arr.length;i++){//比较次数
            int temp = arr[i];//每次需要插入到前面已序数组的元素
            int j = i-1;
            for(;j>=0;j--){
                if(temp<arr[j]){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = temp;
            //System.out.println("第"+i+"轮排序的结果："+display());
        }
        long spend = System.currentTimeMillis() - start;
        System.out.println("插入排序花费毫秒数： " + spend);
    }

    /**
     * 二分插入排序：对插入排序的改进。
     *          优化的是找合适插入位置的算法。
     */
    public void binaryInsertSort(){
        long start = System.currentTimeMillis();
        for (int i=1;i<arr.length;i++){
            int temp = arr[i];
            if(temp<arr[i-1]){
                //在0 - i-1之间找到合适的插入点下标
                int index = binarySearch(0,i-1,temp);
                for(int j=i-1;j>=index;j--){
                    arr[j+1] = arr[j]; //将下标后的元素都后移一位
                }
                arr[index] = temp;
            }
            //System.out.println("第"+i+"轮排序的结果："+display());
        }
        long spend = System.currentTimeMillis() - start;
        System.out.println("二分插入排序花费毫秒数： " + spend);
    }

    private int binarySearch(int left,int right ,int target){
        while (left<=right){
            int mid = (left + right) /2;
            if(target<arr[mid]){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    public void two_wayInsertSort(){

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
