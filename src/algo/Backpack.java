package algo;

/*
 *Первая строка содержит количество предметов 1≤n≤10^3 и вместимость рюкзака 0≤W≤2*10^6.
 * Каждая из следующих n строк задаёт стоимость 0≤ci≤2*10^6 и объём 0<wi≤2*10^6 предмета (n, W, ci, wi — целые числа).
 * Выведите максимальную стоимость частей предметов (от каждого предмета можно отделить любую часть,
 * стоимость и объём при этом пропорционально уменьшатся), помещающихся в данный рюкзак,
 * с точностью не менее трёх знаков после запятой.
 *
 */

import java.util.*;


public class Backpack {
    private static final int PRICE = 0;
    private static final int VOLUME = 1;


    private static void process(List<double[]> things, int capacity){
        things.sort((x,y) -> Double.compare(y[0]/y[1], x[0]/x[1]));
        int got = 0;
        double value = 0d;
        for (double[] nextThing : things){
            if (nextThing[VOLUME] < capacity - got){
                got += nextThing[VOLUME];
                value += nextThing[PRICE];
            } else {
                value += nextThing[PRICE] / nextThing[VOLUME] * (capacity - got);
                break;
            }
        }
        System.out.printf("%.3f", value);
    }

    private static void readData(){
        Scanner in = new Scanner(System.in);
        int count = in.hasNextInt() ? in.nextInt() : 0;
        int capacity = in.hasNextInt() ? in.nextInt() : 0;
        List<double[]> things = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            double price = in.hasNextInt() ? in.nextInt() : 0;
            double volume = in.hasNextInt() ? in.nextInt() : 0;
            things.add(new double[]{price, volume});
        }
        process(things, capacity);
    }

    public static void main(String[] args){
        readData();
    }

}
