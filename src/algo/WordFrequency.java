package algo;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.*;


// top10 words by frequency from input stream

public class WordFrequency {

    public static void main(String[] args){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset()));
        in.lines().map(String::toLowerCase).flatMap(x -> Stream.of(x.split("[^a-zёа-я0-9]+")))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
                .entrySet().stream().sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue)
                                                      .reversed()
                                                      .thenComparing(Map.Entry::getKey))
                .limit(10)
                .forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
    }
}
