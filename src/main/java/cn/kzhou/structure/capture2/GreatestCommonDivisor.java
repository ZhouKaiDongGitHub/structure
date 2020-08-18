package cn.kzhou.structure.capture2;

/**
 * 最大公约数
 */
public class GreatestCommonDivisor {
    // 33 22     1989 1590     15  60
    public static int findGCD(int a, int b){

        while (b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
