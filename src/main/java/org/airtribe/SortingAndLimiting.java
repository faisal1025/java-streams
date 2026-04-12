package org.airtribe;
import java.util.*;
import java.util.stream.*;

public class SortingAndLimiting {

    public static void sortingAndLimiting() {
        List<String> sentences = Arrays.asList(
                "java spring boot",
                "microservices docker kubernetes",
                "aws azure gcp",
                "java docker aws"
        );
        /*
        * Sort all words alphabetically
        * */
        System.out.println("----------------Sort All Words Alphabetically--------------");
        List<String> sortedWords = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedWords);

        System.out.println("------------------------sort the strings list-----------------");
        Collections.sort(sentences, (a, b) -> b.compareTo(a));
        System.out.println(sentences);

        /*
        * Sort words by length (ascending)
        * */
        System.out.println("-----------------Sort words by length (ascending)------------");
        List<String> sortByLengthAsc = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(sortByLengthAsc);

        /*
        * Sort words by length (descending)
        * */
        System.out.println("-----------------Sort words by length (descending)------------");
        List<String> sortedList = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println(sortedList);

        /*
        * Get top 5 longest words
        * */
        System.out.println("-----------------Get top 5 longest words------------");
        List<String> longestWords = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .sorted(Comparator.comparingInt(String::length).reversed())
                .distinct()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(longestWords);

        /*
        * Skip first 3 words and print remaining
        * */
        System.out.println("-----------------Skip first 3 words and print remaining------------");
        System.out.println(sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .skip(3)
                .collect(Collectors.toList()));
    }
}
