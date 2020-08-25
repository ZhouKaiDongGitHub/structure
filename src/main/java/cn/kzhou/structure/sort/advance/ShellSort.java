package cn.kzhou.structure.sort.advance;

public class ShellSort {
    private int[] array;

    public ShellSort(int[] array){
        this.array = array;
    }

    public void sort(){
        long start = System.currentTimeMillis();

        int len = array.length;
        int h = 1;
        while( 3*h+1< len){  //确定第一轮排序时的间隔
            h = 3*h+1;
        }

        while(h>0){
            for(int i=0;i<h;i++){
                shellInsertSort(i,h);  //对间隔为h的元素进行插入排序
            }
            h = (h-1)/3;  //下一轮排序的间隔
        }

        long spend = System.currentTimeMillis() - start;
        System.out.println("Shell排序花费毫秒数： " + spend);
    }

    private void shellInsertSort(int beginIndex,int increment){

        int targetIndex =beginIndex+increment;  //欲插入元素的下标

        while(targetIndex<array.length){
            int temp =array[targetIndex];

            int previousIndex =targetIndex - increment;  //前一个元素下标，间隔为increment
            while(previousIndex>=0&&array[previousIndex]>temp){
                array[previousIndex+increment]= array[previousIndex];  //比欲插入数据项大的元素后移一位
                previousIndex =previousIndex - increment;
            }
            array[previousIndex+increment]= temp;  //插入到合适的位置

            targetIndex =targetIndex+increment;  //插入下一个元素
        }

    }

    public int getIndex(int index){
        if(array.length>=index){
            return array[index];
        }
        return -1;
    }
}
