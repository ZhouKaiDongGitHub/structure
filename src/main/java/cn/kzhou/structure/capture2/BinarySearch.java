package cn.kzhou.structure.capture2;

/**
 * 折半查找
 */
public class BinarySearch {
    //arr[1,3,5,6,8,12,34,45,56,66,78,94,121]
    public static int binarySer(int[] arr,int x){
        int low = 0,high = arr.length-1;
        while (low <= high){
            int mid = low+high/2;
            if(x<arr[mid]){
                high = mid-1;
            }else if(x>arr[mid]){
                low = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
