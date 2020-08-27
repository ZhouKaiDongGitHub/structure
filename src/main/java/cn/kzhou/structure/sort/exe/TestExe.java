package cn.kzhou.structure.sort.exe;

import cn.kzhou.structure.sort.SimpleChoice;
import cn.kzhou.structure.sort.advance.QuickSort;
import cn.kzhou.structure.sort.advance.exe.HeapSort2;
import cn.kzhou.structure.sort.advance.exe.QuickSort2;

import java.util.Random;

public class TestExe {

    public static void main(String[] args) {
        Random random = new Random();
        int[] testArray = new int[20];
        for(int i=0;i<20;i++){
            testArray[i] = random.nextInt(20);
        }
        int[] testArray1 = testArray.clone();
        int[] testArray2 = testArray.clone();
        int[] testArray3 = testArray.clone();
        int[] testArray4 = testArray.clone();
        int[] testArray5 = testArray.clone();
        int[] testArray6 = testArray.clone();

        MaoPaoSort2 maoPaoSort2 = new MaoPaoSort2(testArray1);
        maoPaoSort2.sort();
        System.out.println(maoPaoSort2.display());

        SimpleChoice2 simpleChoice2 = new SimpleChoice2(testArray2);
        simpleChoice2.sort();
        System.out.println(simpleChoice2.display());

        DirectInsert2 directInsert2 = new DirectInsert2(testArray3);
        directInsert2.sort();
        System.out.println(directInsert2.display());

        DirectInsert2 directInsert22 = new DirectInsert2(testArray4);
        directInsert22.sort2();
        System.out.println(directInsert22.display());

        QuickSort2 quickSort2 = new QuickSort2(testArray5);
        quickSort2.sort();
        System.out.println(quickSort2.display());

        HeapSort2 heapSort2 = new HeapSort2(testArray6);
        heapSort2.sort();
        System.out.println(heapSort2.display());
    }
}
