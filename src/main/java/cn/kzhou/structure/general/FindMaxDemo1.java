package cn.kzhou.structure.general;

public class FindMaxDemo1 {

    /**
     *
     * @param arr  传入的参数类型为泛型
     * @param <T>  声明这是一个泛型方法，且对T类型进行限定为任意类型
     * @return  返回一个T类型，即传入的类型
     */
    public static <T> T findMax2(T[] arr,Comparator<T> cmp){
        int maxIndex = 0;
        for (int i = 1; i <arr.length ; i++) {
            if(cmp.compare(arr[i],arr[maxIndex])>0){
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }
}
