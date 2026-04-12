package org.airtribe;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringLogic {
    private static List<String> sentences = Arrays.asList(
            "java spring boot aei",
            "microservices docker ou kubernetes sagas",
            "aws azure aoi gcp minnim",
            "java docker euu aws"
    );

    public static void advancedStringLogic() {
        /*
         * Find words containing only vowels
         * eg. [java, spring, boot, aei, aws, docker, euu]
         * output: [aei, euu]
         * */

        System.out.println("---------------Words Containing Only Vowels------------------");
        List<String> vowelsWords = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .filter(word -> word.toLowerCase().chars()
                        .peek(letter -> System.out.printf("%s ", letter))
                        .allMatch(letter -> "aeiou".indexOf(letter) != -1))
                .collect(Collectors.toList());
        System.out.println();
        System.out.println("--------------All the Vowels Word---------------");
        vowelsWords.forEach(System.out::println);
        System.out.println("--------------------------------------------------------------");


        /*
         * Find words containing both 'a' and 's'
         * eg. [java, is, awesome, aws, is, also]
         * output: [awesome, aws, also]
         * */
        System.out.println("----------------Words Containing both 'a' and 's'------------------ ");
        List<String> wordsAandS = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))) // Stream<String>
                .distinct()
                .filter(word -> "as".chars()
                        .allMatch(letter -> word.indexOf(letter) != -1))
                .collect(Collectors.toList());
        wordsAandS.forEach(System.out::println);


        /*
         * Find Longest Word
         *
         * */
        System.out.println("-------------------Longest Word-------------------------------------");
        Optional<String> longestWord = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .max(Comparator.comparingInt(String::length));
        if(longestWord.isPresent())
            System.out.println(longestWord.get());


        /*
         * Find Shortest Word
         *
         * */
        System.out.println("-------------------Shortest Word------------------------------");
        Optional<String> shortestString = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .reduce((u, v) -> Integer.compare(u.length(), v.length()) <= 0 ? u : v);
        if(shortestString.isPresent()){
            System.out.println(shortestString.get());
        }

        /*
         * Find palindromic words
         * */
        List<String> palindromic = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .filter(word -> IntStream.range(0, word.length()).allMatch(index -> word.charAt(index) == word.charAt(word.length() - 1 - index )))
                .collect(Collectors.toList());
        System.out.println("-------------------Palindromic Words------------------------------");
        System.out.println("Palindromic Words: "+palindromic.size());
        palindromic.forEach(System.out::println);

    }
}
