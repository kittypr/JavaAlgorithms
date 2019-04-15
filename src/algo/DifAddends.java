package algo;

/*
* По данному числу 1≤n≤10^9 найдите максимальное число k, для которого n можно представить
* как сумму k различных натуральных слагаемых. Выведите в первой строке число k, во второй — k слагаемых.
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifAddends {

    private static void process(int number){
        if (number == 1 || number == 2){
            System.out.println(1);
            System.out.println(number);
            return;
        }
        int test = 1;
        List<Integer> res = new ArrayList<>();
        while (number != 0) {
            if (number - test >= test+1) {
                number -= test;
                res.add(test);
                test++;
            } else {
                res.add(number);
                break;
            }
        }
        System.out.println(res.size());
        res.forEach(System.out::println);
    }

    private static void readData(){
        Scanner in = new Scanner(System.in);
        int number = in.hasNextInt() ? in.nextInt() : 0;
        process(number);
    }

    public static void main(String[] args){
        readData();
    }
}
