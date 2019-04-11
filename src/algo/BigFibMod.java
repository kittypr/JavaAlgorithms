package algo;

import java.util.Scanner;

/* Даны целые числа 1≤n≤10^18 и 2≤m≤10^5, необходимо найти остаток от деления n-го числа Фибоначчи на m.*/

public class BigFibMod {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        int divisor = in.nextInt();
        int[] piz = new int[divisor*6+2];
        piz[0] = 0;
        piz[1] = 1;
        int per = divisor*6;
        for (int i = 2; i < divisor*6+2; i++){
            piz[i] = (piz[i-2] + piz[i-1]) % divisor;
            if (piz[i] == 1 && piz[i-1] == 0) {
                per = i-1;
                break;
            }
        }
        int index = (int) (num % per);
        System.out.println(piz[index]);
    }
}
