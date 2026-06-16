# Java Stream API Interview Questions (Most Asked)

## 1. Find Duplicate Elements

```java
List<Integer> list = Arrays.asList(1,2,3,4,2,5,3,6);

Set<Integer> set = new HashSet<>();

list.stream()
    .filter(n -> !set.add(n))
    .forEach(System.out::println);
```

**Output**
```
2
3
```

---

## 2. Find First Non-Repeated Character

```java
String str = "aabbcdde";

Character result = str.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(
                Function.identity(),
                LinkedHashMap::new,
                Collectors.counting()))
        .entrySet()
        .stream()
        .filter(e -> e.getValue() == 1)
        .map(Map.Entry::getKey)
        .findFirst()
        .orElse(null);

System.out.println(result);
```

**Output**
```
c
```

---

## 3. Count Occurrence of Each Character

```java
String str = "banana";

Map<Character, Long> map =
        str.chars()
           .mapToObj(c -> (char)c)
           .collect(Collectors.groupingBy(
                   Function.identity(),
                   Collectors.counting()));

System.out.println(map);
```

**Output**
```
{b=1, a=3, n=2}
```

---

## 4. Find Second Highest Number

```java
List<Integer> list = Arrays.asList(5,8,2,10,7);

Integer secondHighest =
        list.stream()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst()
            .orElse(null);

System.out.println(secondHighest);
```

**Output**
```
8
```

---

## 5. Find Longest String

```java
List<String> names = Arrays.asList("Java", "SpringBoot", "Microservice");

String longest =
        names.stream()
             .max(Comparator.comparing(String::length))
             .orElse("");

System.out.println(longest);
```

---

## 6. Partition Even and Odd Numbers

```java
List<Integer> nums = Arrays.asList(1,2,3,4,5,6);

Map<Boolean, List<Integer>> result =
        nums.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));

System.out.println(result);
```

**Output**
```
{false=[1,3,5], true=[2,4,6]}
```

---

# FlatMap Questions

## 7. Flatten List of Lists

```java
List<List<String>> list =
        Arrays.asList(
                Arrays.asList("A","B"),
                Arrays.asList("C","D")
        );

List<String> result =
        list.stream()
            .flatMap(Collection::stream)
            .toList();

System.out.println(result);
```

**Output**
```
[A, B, C, D]
```

### Why flatMap Instead of map?

Using map:

```java
list.stream()
    .map(Collection::stream);
```

Result:

```java
Stream<Stream<String>>
```

Using flatMap:

```java
list.stream()
    .flatMap(Collection::stream);
```

Result:

```java
Stream<String>
```

---

## 8. Employee and Skills Flattening

### Employee Class

```java
class Employee {
    private String name;
    private List<String> skills;

    // getters/setters
}
```

### Find All Unique Skills

```java
List<String> skills =
        employees.stream()
                 .flatMap(emp -> emp.getSkills().stream())
                 .distinct()
                 .toList();
```

---

## 9. Count All Skills

```java
long count =
        employees.stream()
                 .flatMap(emp -> emp.getSkills().stream())
                 .count();
```

---

## 10. Find Employees Having Java Skill

```java
employees.stream()
         .filter(emp ->
                 emp.getSkills()
                    .stream()
                    .anyMatch(skill -> skill.equals("Java")))
         .forEach(System.out::println);
```

---

# Scenario-Based Employee Questions

## Employee Class

```java
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;

    // getters/setters
}
```

---

## 11. Find Highest Salary Employee

```java
Employee highest =
        employees.stream()
                 .max(Comparator.comparing(Employee::getSalary))
                 .orElse(null);
```

---

## 12. Department Wise Employees

```java
Map<String, List<Employee>> result =
        employees.stream()
                 .collect(Collectors.groupingBy(
                         Employee::getDepartment));
```

---

## 13. Average Salary Per Department

```java
Map<String, Double> result =
        employees.stream()
                 .collect(Collectors.groupingBy(
                         Employee::getDepartment,
                         Collectors.averagingDouble(
                                 Employee::getSalary)));
```

---

## 14. Highest Paid Employee in Each Department

```java
Map<String, Optional<Employee>> result =
        employees.stream()
                 .collect(Collectors.groupingBy(
                         Employee::getDepartment,
                         Collectors.maxBy(
                                 Comparator.comparing(
                                         Employee::getSalary))));
```

---

## 15. Count Employees in Each Department

```java
Map<String, Long> result =
        employees.stream()
                 .collect(Collectors.groupingBy(
                         Employee::getDepartment,
                         Collectors.counting()));
```

---

## 16. Convert List to Map

```java
Map<Integer, Employee> map =
        employees.stream()
                 .collect(Collectors.toMap(
                         Employee::getId,
                         Function.identity()));
```

---

## 17. Join Strings

```java
String result =
        names.stream()
             .collect(Collectors.joining(", "));
```

**Output**
```
Java, Spring, AWS
```

---

## 18. Find Top 3 Salaries

```java
employees.stream()
         .map(Employee::getSalary)
         .distinct()
         .sorted(Comparator.reverseOrder())
         .limit(3)
         .forEach(System.out::println);
```

---

## 19. Group Employees by Age

```java
Map<Integer, List<Employee>> result =
        employees.stream()
                 .collect(Collectors.groupingBy(
                         Employee::getAge));
```

---

## 20. Check If All Employees Earn More Than 50k

```java
boolean result =
        employees.stream()
                 .allMatch(emp -> emp.getSalary() > 50000);
```

---

# Advanced Stream Interview Questions

## 21. Find Employee with Nth Highest Salary

```java
int n = 3;

Employee employee =
        employees.stream()
                 .sorted(Comparator.comparing(Employee::getSalary)
                                   .reversed())
                 .skip(n - 1)
                 .findFirst()
                 .orElse(null);
```

---

## 22. Find Duplicate Strings

```java
List<String> names = Arrays.asList(
        "Java", "Spring", "Java", "AWS", "Spring"
);

Set<String> set = new HashSet<>();

names.stream()
     .filter(name -> !set.add(name))
     .forEach(System.out::println);
```

---

## 23. Find Most Frequent Element

```java
List<Integer> nums =
        Arrays.asList(1,2,2,3,3,3,4,4);

Integer result =
        nums.stream()
            .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .get()
            .getKey();
```

---

## 24. Sum of Salaries Department Wise

```java
Map<String, Double> result =
        employees.stream()
                 .collect(Collectors.groupingBy(
                         Employee::getDepartment,
                         Collectors.summingDouble(
                                 Employee::getSalary)));
```

---

## 25. Find Youngest Employee

```java
Employee youngest =
        employees.stream()
                 .min(Comparator.comparing(
                         Employee::getAge))
                 .orElse(null);
```

---

# Theory Questions

## Difference Between map() and flatMap()

| map() | flatMap() |
|---------|---------|
| One-to-One transformation | One-to-Many transformation |
| Returns Stream<Stream<T>> | Returns Stream<T> |
| Does not flatten | Flattens nested collections |

---

## Difference Between findFirst() and findAny()

### findFirst()

```java
stream.findFirst();
```

Returns the first element of an ordered stream.

### findAny()

```java
stream.findAny();
```

Returns any element, useful in parallel streams.

---

## Difference Between limit() and skip()

### limit()

```java
stream.limit(5);
```

Returns first 5 elements.

### skip()

```java
stream.skip(5);
```

Skips first 5 elements.

---

## Intermediate Operations

- map()
- filter()
- sorted()
- distinct()
- flatMap()
- peek()

### Example

```java
list.stream()
    .filter(x -> x > 10)
    .map(x -> x * 2);
```

No execution until terminal operation is called.

---

## Terminal Operations

- collect()
- count()
- reduce()
- forEach()
- findFirst()
- findAny()
- max()
- min()

### Example

```java
list.stream()
    .filter(x -> x > 10)
    .collect(Collectors.toList());
```

---

# Top 10 Stream Questions Asked in Interviews

1. Find duplicate elements in a list.
2. Find first non-repeated character.
3. Find second highest salary.
4. Difference between map() and flatMap().
5. Department-wise highest salary employee.
6. Count employees department-wise.
7. Find top 3 salaries.
8. Convert List<Employee> to Map.
9. Find all unique skills using flatMap().
10. Group employees by department and calculate average salary.

---
**Recommended for Java Spring Boot Interviews (0–3 YOE):**
Focus heavily on:
- map vs flatMap
- groupingBy
- partitioningBy
- reduce
- Optional
- Comparator
- Collectors
- Method References
- Functional Interfaces
- Employee-based Stream Problems