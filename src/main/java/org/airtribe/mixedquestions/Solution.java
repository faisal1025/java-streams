package org.airtribe.mixedquestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {


    // Find Duplicate Elements
    public void findDuplicateElements() {
        List<Integer> arr = Arrays.asList(2, 3, 4, 5, 6, 7, 7, 3);
        Set<Integer> st = new HashSet<>();
        List<Integer> duplicate = arr.stream().filter(num -> !st.add(num)).toList();
        duplicate.forEach(System.out::println);
    }

    // First Non-Repeated Character
    public void firstNonRepeatedChar() {
        String str = "aabcdde";
        Character ch = str.chars().mapToObj(c -> (char) c).
                collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println(ch);
    }

    // Count the Occurrence of Each Character
    public void freqElement() {
        String str = "banana";
        str.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().forEach(e -> System.out.println(e.getKey()+" - "+e.getValue()));

    }
}
