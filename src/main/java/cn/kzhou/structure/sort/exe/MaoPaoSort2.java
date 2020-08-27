package cn.kzhou.structure.sort.exe;

public class MaoPaoSort2 {

    private int[] array;

    public MaoPaoSort2(int[] array){
        this.array = array;
    }

    public void sort(){

        for (int i=0;i<array.length-1;i++){
            for (int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] =temp;
                }
            }
        }
    }
    public void sort2(){

        for (int i=0;i<array.length-1;i++){
            boolean flag = false;
            for (int j=0;j<array.length-i;j++){
                if(array[j]>array[j+1]){
                    flag = true;//发生了交换
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = array[j];
                }
            }
            if(!flag){
                return;
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
