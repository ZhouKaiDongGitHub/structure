package cn.kzhou.structure.sort;

import cn.kzhou.structure.sort.advance.MergeSort;
import cn.kzhou.structure.sort.advance.QuickSort;

import java.util.Random;

public class Test {

    public static void main(String[] args) {

        Random random = new Random();
        int[] testArray = new int[100000];
        for(int i=0;i<100000;i++){
            testArray[i] = random.nextInt(100000);
        }
        int[] testArray1 = testArray.clone();
        int[] testArray2 = testArray.clone();
        int[] testArray3 = testArray.clone();
        int[] testArray4 = testArray.clone();
        int[] testArray5 = testArray.clone();
        int[] testArray6 = testArray.clone();
        MaoPaoSort maoPao = new MaoPaoSort(testArray1);
        maoPao.sort();
        System.out.println(maoPao.getIndex(100));

        SimpleChoice simpleChoice = new SimpleChoice(testArray2);
        simpleChoice.sort();
        System.out.println(simpleChoice.getIndex(100));

        DirectInsert directInsert = new DirectInsert(testArray3);
        DirectInsert directInsert2 = new DirectInsert(testArray4);
        directInsert.sort();
        System.out.println(directInsert.getIndex(100));
        directInsert2.binaryInsertSort();
        System.out.println(directInsert2.getIndex(100));

        QuickSort quickSort = new QuickSort(testArray5);
        quickSort.sort();
        System.out.println(quickSort.getIndex(100));

        MergeSort mergeSort = new MergeSort(testArray6);
        mergeSort.sort();
        System.out.println(mergeSort.getIndex(100));

    }
}
