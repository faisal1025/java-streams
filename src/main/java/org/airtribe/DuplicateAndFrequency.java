package org.airtribe;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateAndFrequency {


    public static void duplicateAndFrequency() {
        List<String> data = Arrays.asList(
                "java spring boot",
                "microservices docker kubernetes",
                "aws azure gcp",
                "java docker aws"
        );
        System.out.println("-------------------------Find Duplicate Words----------------");
        Map<String, Long> map = data.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        Map<String, Long> duplicate = map.entrySet().stream().filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
        for(Map.Entry<String, Long> entry: duplicate.entrySet()){
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }

        System.out.println("-----------------------Count frequency of each word-----------");
        Map<String, Long> frequency = data.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        frequency.forEach((key, val) -> System.out.println(key+" - "+val));

        System.out.println("------------------Find Word With highest frequency-----------");
        Optional<Map.Entry<String, Long>> frequencyMax = data.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(word -> word, Collectors.counting()),
        freq -> freq.entrySet().stream().max(Map.Entry.comparingByValue())
                ));
        if(frequencyMax.isPresent()) System.out.println(frequencyMax.get().getKey()+" - "+frequencyMax.get().getValue());

        System.out.println("--------------------find word with lowest frequency--------------");
        Optional<Map.Entry<String, Long>> leastFreq = data.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(words -> words, Collectors.counting()),
                        freq -> freq.entrySet().stream().min(Map.Entry.comparingByValue())
                ));
        if(leastFreq.isPresent()) System.out.println(leastFreq.get().getKey()+" - "+leastFreq.get().getValue());

        System.out.println("---------------Print words that appear more than Once--------------");
        Map<String, Long> duplicateWords = data.stream().flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(words -> words, Collectors.counting()),
                        freq -> freq.entrySet().stream()
                                .filter(e -> e.getValue() > 1)
                                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()))
                ));
        duplicateWords.forEach((key, val) -> {
            System.out.println(key+" - "+val);
        });
    }
}
