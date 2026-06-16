🔹 1. Beginner Level (Must Know Basics)
✅ Problem 1: Filter Even Numbers

Given a list of integers, return only even numbers.

List<Integer> nums = List.of(1,2,3,4,5,6);

👉 Expected: [2,4,6]

✅ Problem 2: Convert List to Uppercase
List<String> names = List.of("faisal", "john", "alex");

👉 Output: ["FAISAL", "JOHN", "ALEX"]

✅ Problem 3: Sum of All Numbers

👉 Use reduce()

✅ Problem 4: Count Strings with Length > 3
🔹 2. Intermediate Level (Frequently Asked in Interviews)
✅ Problem 5: Find Duplicate Elements
List<Integer> nums = List.of(1,2,3,2,4,5,1);

👉 Output: [1,2]

✅ Problem 6: Find First Non-Repeated Character
String input = "java stream";

👉 Output: j

✅ Problem 7: Sort Employees by Salary
class Employee {
String name;
double salary;
}

👉 Sort descending using streams

✅ Problem 8: Group Strings by Length
List<String> list = List.of("a", "bb", "ccc");

👉 Output:

{
1: ["a"],
2: ["bb"],
3: ["ccc"]
}
✅ Problem 9: Find Max/Min Value
✅ Problem 10: Remove Duplicates
🔹 3. Advanced Level (Highly Asked)
✅ Problem 11: Find Second Highest Number
✅ Problem 12: Partition Numbers (Even/Odd)

👉 Use Collectors.partitioningBy()

✅ Problem 13: Find Top 3 Highest Salaries
✅ Problem 14: Flatten a List of Lists
List<List<Integer>> list = List.of(List.of(1,2), List.of(3,4));

👉 Output: [1,2,3,4]

✅ Problem 15: Convert List to Map
List<Employee>

👉 Key = name, Value = salary

🔹 4. Real Interview Scenarios (Very Important)
✅ Problem 16: Word Frequency Count
String sentence = "java is java and java is powerful";

👉 Output:

java=3, is=2, and=1, powerful=1
✅ Problem 17: Find Longest String in List
✅ Problem 18: Check if All Elements Match Condition

👉 Use:

allMatch()
anyMatch()
noneMatch()
✅ Problem 19: Merge Two Lists and Remove Duplicates
✅ Problem 20: Find Employee with Highest Salary
🔹 5. Tricky Questions (Interview Killers 🔥)
✅ Problem 21: Reverse Each Word in String Using Streams
✅ Problem 22: Find Character Frequency
✅ Problem 23: Sort Map by Value Using Streams
✅ Problem 24: Find Missing Number in Array (1–N)
✅ Problem 25: Custom Collector Implementation (Advanced)
🔹 How Interviewers Think (Important Insight)

Most interviews (like product companies) focus on:

map(), filter(), reduce()
collect(), groupingBy()
flatMap()
sorted(), distinct()
Optional
Parallel streams (basic idea)