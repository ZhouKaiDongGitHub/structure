package cn.kzhou.structure.sort.advance;

import cn.kzhou.structure.sort.advance.exe.MergeSort2;

import java.util.Random;

public class Tests {

    public static void main(String[] args) {
        Random random = new Random();
        int[] testArray = new int[1000000];
        for(int i=0;i<1000000;i++){
            testArray[i] = random.nextInt(1000000);
        }
        int[] testArray1 = testArray.clone();
        int[] testArray2 = testArray.clone();
        int[] testArray3 = testArray.clone();

        MergeSort mergeSort = new MergeSort(testArray1);
        mergeSort.sort();
        System.out.println(mergeSort.getIndex(9999));

        QuickSort quickSort = new QuickSort(testArray2);
        quickSort.sort();
        System.out.println(quickSort.getIndex(9999));

        HeapSort heapSort = new HeapSort(testArray3);
        heapSort.sort();
        System.out.println(heapSort.getIndex(9999));
    }
}
