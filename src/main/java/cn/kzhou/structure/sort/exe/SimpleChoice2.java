package cn.kzhou.structure.sort.exe;

public class SimpleChoice2 {

    private int[] array;

    public SimpleChoice2(int[] array){
        this.array = array;
    }

    public void sort(){
        for (int i=0; i<array.length-1;i++){
            int min = i;//最小值为第一个
            for (int j=i+1;j<array.length;j++){

                if(array[j]<array[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public String display(){
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<array.length;i++){

            sb.append(array[i] + "\t");
        }
        return sb.toString();
    }
}
