package org.airtribe;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.*;

public class MapAndCollectors {
    private static List<String> sentence = Arrays.asList(
            "java spring boot",
            "microservices docker kubernetes",
            "aws azure gcp",
            "java docker aws"
    );

    public static void mapAndCollectors() {
        /*
        * Group Words by their length
        * 4 -> [java, boot]
        * 6 -> [spring, docker]
        * so on...
        * */
        System.out.println("--------------------Group words by their length----------------------");
        Map<Integer, Set<String>> wordsLength = sentence.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.groupingBy(word -> word.length(), Collectors.toSet()
                ));
        wordsLength.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });

        System.out.println("--------------------Group words by first character----------------------");
        Map<Character, String> groupByFirstChar = sentence.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(
                        Collectors.groupingBy(
                                word -> word.toUpperCase().charAt(0),
                                Collectors.collectingAndThen(
                                        Collectors.mapping(String::toUpperCase, Collectors.toSet()), // to set for the unique value
                                        st -> String.join(", ", st) // then converting into string
                                )
                        )
                );

        groupByFirstChar.forEach((key, val) -> {
            System.out.println(key+ " -> "+val);
        });

        System.out.println("-----------------Map word --> Word length------------------------");
        Map<String, Integer> mp = sentence.stream().flatMap(sen -> Arrays.stream(sen.split(" ")))
                                        .distinct()
                                        .collect(Collectors.toMap(word -> word, word -> word.length()));
        mp.forEach((key, val) -> {
            System.out.println(key+ " -> "+val);
        });


        System.out.println("---------------------Partition By Length > 5-----------------------");
        Map<Boolean, Set<String>> greaterThanFive = sentence.stream().flatMap(sen -> Arrays.stream(sen.split(" ")))
                            .collect(Collectors.partitioningBy(word -> word.length() > 5, Collectors.toSet()));
        for(Map.Entry<Boolean, Set<String>> entry: greaterThanFive.entrySet()){
            System.out.println(entry.getKey()+ " -> "+entry.getValue());
        }

        System.out.println("--------------------------Create Map<Integer, List> (length → words)-------------------");
        Map<Integer, List<String>> mapStringByWord = sentence.stream().flatMap(sen -> Arrays.stream(sen.split(" ")))
                .collect(Collectors.groupingBy(word -> word.length()));
        for(Map.Entry<Integer, List<String>> entry: mapStringByWord.entrySet()){
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
    }

}
