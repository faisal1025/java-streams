package org.airtribe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Basic {
    public static void BasicOperation() {
        List<String> sentences = Arrays.asList(
                "java spring boot",
                "microservices docker kubernetes",
                "aws azure gcp",
                "java docker aws"
        );

        /*
         * Question 1: join all the arrays of string into a single string
         * eg: ["this is spring", "Java is good for creating CPU intensive tasks"]
         * output: "this is spring Java is good for creating CPU intensive tasks"
         * */
        System.out.println("---------------Collectors.joining()-------------------------");
        String str = sentences.stream().collect(Collectors.joining(" "));
        System.out.println(str);
        System.out.println("----------------------------------------");

        /*
         * Question 2: output a single array containing all the words as the element
         * eg: ["this is spring", "Java is good for creating application"]
         * output: ["this", "is", "spring", "Java", "is", "good", "for", "creating", "application"]
         * */
        System.out.println(sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList()));
        System.out.println("------------------------------------------");

        /*
         * Print each word on a new line using Stream
         * */
        sentences.stream().map(sentence -> sentence.split(" "))
                .flatMap(Arrays::stream)
                .forEach(System.out::println);
        System.out.println("------------------------------------------");

        /*
         * Convert all words to uppercase
         * */
        sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase)
                .forEach(word -> System.out.printf("%s ", word));
        System.out.println();
        System.out.println("-------------------------------------------------");

        /*
         * Count the total number of words
         * */
        long num = sentences.stream().flatMap(sen -> Arrays.stream(sen.split(" ")))
                .peek(x -> {
                    System.out.printf("%s ", x);
                })
                .count();
        System.out.println("Count of element: "+num);
        System.out.println("-------------------------------------------------");

        /*
         * Get distinct words only
         * */

        List<String> distinct = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinct);
        System.out.println("-------------------------------------------------");

    }
}
