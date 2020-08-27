package cn.kzhou.structure.sort.exe;

public class DirectInsert2 {

    private int[] array;

    public DirectInsert2(int[] array){
        this.array = array;
    }

    public void sort(){
        for (int i=1;i<array.length;i++){
            int temp = array[i];
            int j = i-1;
            for(;j>=0;j--){
                if(temp<array[j]){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = temp;
        }
    }

    public void sort2(){
        for (int i=1;i<array.length;i++){
            if(array[i]<array[i-1]){
                int temp = array[i];
                int index = findIndex(0,i-1,array[i]);
                for (int j=i-1;j>=index;j--){
                    array[j+1] = array[j];
                }
                array[index] = temp;
            }
        }
    }

    private int findIndex(int left,int right,int element){
        while (left<=right){
            int mid = (left+right)/2;
            if(element<array[mid]){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    public String display(){
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<array.length;i++){

            sb.append(array[i] + "\t");
        }
        return sb.toString();
    }
}
