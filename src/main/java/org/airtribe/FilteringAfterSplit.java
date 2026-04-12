package org.airtribe;

import java.util.*;
import java.util.stream.*;

public class FilteringAfterSplit {
    // We will write a stream query for filtering and split

    public static void filteringAndSplit() {
        List<String> sentences = Arrays.asList(
                "java spring boot",
                "microservices docker kubernetes",
                "aws azure gcp",
                "java docker aws"
        );
        /*
        * Find words that start with "a"
        * */
        System.out.println("---------------------Words Starts with \"a\"---------------------");
        List<String> words = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .filter(word -> word.startsWith("a"))
                .collect(Collectors.toList());
        words.forEach(System.out::println);

        /*
        * Find words with length > 5
        * */
        System.out.println("-------------------Words length > 5-----------------------");
        Map<Boolean, List<String>> map = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.partitioningBy(word -> word.length() > 5));
        map.forEach((k, v) -> {
            if(k == true) {
                v.forEach(System.out::println);
            }
        });

        /*
        * Exclude words containing a letter "o"
        * */
        System.out.println("----------------Exclude Word Containing o-----------------");
        List<String> wordsWithoutO = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .filter(word -> !word.contains("o"))
                .collect(Collectors.toList());
        for(String word: wordsWithoutO){
            System.out.printf("%s, ", word);
        }
        System.out.println();

        /*
        * Get only words ending with "s"
        * */
        System.out.println("------------------Words Ends With \"s\"-------------------");
        List<String> wordsEndsWithS = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .filter(word -> word.endsWith("s") || word.endsWith("S"))
                .collect(Collectors.toList());
        wordsEndsWithS.forEach(System.out::println);

        /*
        * Filter words that contain "java"
        * */
        System.out.println("-----------------------Words Containing \"java\"-------------------");
        System.out.println(sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .filter(word -> word.contains("java"))
                .collect(Collectors.toList()));
    }
}
