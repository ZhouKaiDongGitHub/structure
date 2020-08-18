package cn.kzhou.structure.general;



public class FindMaxDemo {



    /**
     *
     * @param arr  传入的参数类型为泛型
     * @param <T>  声明这是一个泛型方法，且对T类型进行限定为任意类型
     * @return  返回一个T类型，即传入的类型
     */
    public static <T extends Comparable<?super T>> T findMax2(T[] arr){
            int maxIndex = 0;
            for (int i = 1; i <arr.length ; i++) {
                if(arr[i].compareTo(arr[maxIndex])>0){
                    maxIndex = i;
                }
            }
            return arr[maxIndex];
    }

    /*public static void main(String[] args) {
        Shape[] sh1 = new Shape[]{
                new Circle(2.0),
                new Square(3.0),
                new Rectangle(3.0,4.0)
        };
        String[] st1 = new String[]{"Joe","Bom","Lokem","Zeke"};

        System.out.println(findMax(sh1));
        System.out.println(findMax(st1));
    }*/


}
