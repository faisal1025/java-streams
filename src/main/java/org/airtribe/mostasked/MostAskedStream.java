package org.airtribe.mostasked;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MostAskedStream {

    public static void main(String[] args) {
        MostAskedStream mostAskedStream = new MostAskedStream();
        System.out.println("-------------------------Filter Find Even Numbers-------------------------");
        mostAskedStream.findEven();
        System.out.println("-------------------------Convert List to UpperCase-------------------------");
        mostAskedStream.convertToUpperCase();
        System.out.println("-------------------------Find Sum of All Numbers-------------------------");
        mostAskedStream.getSum();
        System.out.println("-------------------------Count Strings with Length > 3-------------------------");
        mostAskedStream.numberOfStringsWithLengthGreaterThan3();
    }

    //    Filter all the even number from a list
    public void findEven() {
        List<Integer> numbers = Arrays.asList(22, 33, 44, 55, 66, 77, 88, 99);
        List<Integer> even = numbers.stream()
                .filter(num -> num%2 == 0).collect(Collectors.toList());
        System.out.println(even);
    }

    // Convert List to uppercase
    public void convertToUpperCase() {
        List<String> words = Arrays.asList("faisal", "java", "love", "programming");
        List<String> upperCaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseWords);
    }

    // Find a sum of all numbers
    public void getSum() {
        List<Integer> numbers = Arrays.asList(2, 4, 3, 5);
        Optional<Integer> sum = numbers.stream().reduce((num, num2) -> num+num2);
        System.out.println(sum.get());
    }

    // Count Strings with Length > 3
    public void numberOfStringsWithLengthGreaterThan3() {
        List<String> words = Arrays.asList("faisal", "java", "love", "programming");
        long count = words.stream().filter(word -> word.length() > 3).count();
        System.out.println(count);
    }
}
