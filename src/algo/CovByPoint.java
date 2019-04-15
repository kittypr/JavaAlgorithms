package algo;

/*
* По данным n отрезкам необходимо найти множество точек минимального размера,
* для которого каждый из отрезков содержит хотя бы одну из точек.
* В первой строке дано число 1≤n≤100 отрезков. Каждая из последующих n строк
* содержит по два числа 0≤l≤r≤10^9, задающих начало и конец отрезка.
* Выведите оптимальное число m точек и сами m точек.
* Если таких множеств точек несколько, выведите любое из них.
*/


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class CovByPoint {
    static final int START = 0;
    static final int END = 1;

    private static void process(List<int[]> segments) {
        segments.sort(Comparator.comparingInt(x -> x[1]));
        List<Integer> points = new ArrayList<>();
        while(!segments.isEmpty()){
            int point = segments.get(0)[END];
            points.add(point);
            while(!segments.isEmpty() && point >= segments.get(0)[START]){
                segments.remove(0);
            }
        }
        System.out.println(points.size());
        points.forEach(System.out::println);
    }

    private static void readData(){
        Scanner in = new Scanner(System.in);
        int count = in.hasNextInt() ? in.nextInt() : 0;
        List<int[]> segments = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            int start = in.hasNextInt() ? in.nextInt() : 0;
            int end = in.hasNextInt() ? in.nextInt() : 0;
            segments.add(new int[]{start, end});
        }
        process(segments);
    }

    public static void main(String[] args){
        readData();
    }
}
