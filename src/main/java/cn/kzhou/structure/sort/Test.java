package cn.kzhou.structure.sort;

import java.util.Random;

public class Test {

    public static void main(String[] args) {

        Random random = new Random();
        int[] testArray = new int[500000];
        for(int i=0;i<500000;i++){
            testArray[i] = random.nextInt(500000);
        }
        int[] testArray1 = testArray.clone();
        int[] testArray2 = testArray.clone();
        int[] testArray3 = testArray.clone();
        int[] testArray4 = testArray.clone();
        MaoPaoSort maoPao = new MaoPaoSort(testArray1);
        //maoPao.sort();
        //System.out.println(maoPao.getIndex(1000));

        SimpleChoice simpleChoice = new SimpleChoice(testArray2);
        //simpleChoice.sort();
        //System.out.println(simpleChoice.getIndex(1000));

        DirectInsert directInsert = new DirectInsert(testArray3);
        DirectInsert directInsert2 = new DirectInsert(testArray4);
        directInsert.sort();
        System.out.println(directInsert.getIndex(1000));
        directInsert2.binaryInsertSort();
        System.out.println(directInsert2.getIndex(1000));


    }
}
