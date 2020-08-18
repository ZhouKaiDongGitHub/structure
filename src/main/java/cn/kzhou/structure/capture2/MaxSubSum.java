package cn.kzhou.structure.capture2;

public class MaxSubSum  {

    /**
     * 最大子序列和求解
     * @return 最大子序列和值
     */
    public static int maxSub(int [] arr){
        int max = 0;  //最大和值
        for (int i = 0;i< arr.length;i++){
            for(int j = i;j< arr.length;j++){
                int thisSum = 0;
                for(int k = i;k<=j;k++){
                    thisSum += arr[k];
                    if(thisSum>max){
                        max = thisSum;
                    }
                }
            }
        }
        return max;
    }
    /**
     * 最大子序列和求解
     * @return 最大子序列和值
     */
    public static int maxSub2(int [] arr){
        int max = 0;  //最大和值
        for (int i = 0;i< arr.length;i++){
            int thisSum = 0;
            for(int j = i;j< arr.length;j++){
                thisSum += arr[j];
                if(thisSum>max){
                    max = thisSum;
                }
            }
        }
        return max;
    }

    /**
     * 最大子序列和求解
     * @return 最大子序列和值
     */
    public static int maxSub3(int [] arr){
        // arr[-15,2,9,-10,-28,17,12,26]
        int maxValue = 0; int thisSum = 0;
        for(int i = 0;i<arr.length;i++){
            thisSum += arr[i];
            if(thisSum>maxValue){
                maxValue = thisSum;
            }else if(thisSum<0){
                thisSum = 0;
            }
        }
       return 0;
    }
}
