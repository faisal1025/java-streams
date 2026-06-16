# Employee Stream API Interview Questions

````md
# Java 8 Stream API - Employee Interview Questions

## Employee Class

```java
public class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;
    private String gender;

    // Constructor
    public Employee(int id, String name, String department,
                    double salary, int age, String gender) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
}
````

---

# 1. Find Employees from IT Department

```java
employees.stream()
        .filter(e -> e.getDepartment().equals("IT"))
        .forEach(System.out::println);
```

---

# 2. Find Employees Having Salary Greater Than 50000

```java
employees.stream()
        .filter(e -> e.getSalary() > 50000)
        .forEach(System.out::println);
```

---

# 3. Find Employees Between Age 25 and 35

```java
employees.stream()
        .filter(e -> e.getAge() >= 25 && e.getAge() <= 35)
        .forEach(System.out::println);
```

---

# 4. Get All Employee Names

```java
List<String> names = employees.stream()
        .map(Employee::getName)
        .toList();
```

---

# 5. Convert Employee Names to Uppercase

```java
employees.stream()
        .map(e -> e.getName().toUpperCase())
        .forEach(System.out::println);
```

---

# 6. Sort Employees by Salary Ascending

```java
employees.stream()
        .sorted(Comparator.comparing(Employee::getSalary))
        .forEach(System.out::println);
```

---

# 7. Sort Employees by Salary Descending

```java
employees.stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .forEach(System.out::println);
```

---

# 8. Sort Employees by Age then Name

```java
employees.stream()
        .sorted(Comparator.comparing(Employee::getAge)
        .thenComparing(Employee::getName))
        .forEach(System.out::println);
```

---

# 9. Group Employees by Department

```java
Map<String, List<Employee>> map = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment));
```

---

# 10. Count Employees in Each Department

```java
Map<String, Long> map = employees.stream()
        .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.counting()
        ));
```

---

# 11. Find Average Salary of Each Department

```java
Map<String, Double> map = employees.stream()
        .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
        ));
```

---

# 12. Find Highest Paid Employee in Each Department

```java
Map<String, Optional<Employee>> map = employees.stream()
        .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.maxBy(
                        Comparator.comparing(Employee::getSalary)
                )
        ));
```

---

# 13. Find Total Salary of Employees

```java
double total = employees.stream()
        .mapToDouble(Employee::getSalary)
        .sum();
```

---

# 14. Find Average Salary

```java
double avg = employees.stream()
        .mapToDouble(Employee::getSalary)
        .average()
        .orElse(0);
```

---

# 15. Find Employee with Maximum Salary

```java
Employee emp = employees.stream()
        .max(Comparator.comparing(Employee::getSalary))
        .orElse(null);
```

---

# 16. Find Youngest Employee

```java
Employee emp = employees.stream()
        .min(Comparator.comparing(Employee::getAge))
        .orElse(null);
```

---

# 17. Find Second Highest Salary Employee

```java
Employee emp = employees.stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .skip(1)
        .findFirst()
        .orElse(null);
```

---

# 18. Find Top 3 Highest Paid Employees

```java
employees.stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .limit(3)
        .forEach(System.out::println);
```

---

# 19. Find Duplicate Employee Names

```java
Set<String> set = new HashSet<>();

employees.stream()
        .map(Employee::getName)
        .filter(name -> !set.add(name))
        .forEach(System.out::println);
```

---

# 20. Check if All Employees Have Salary Greater Than 30000

```java
boolean result = employees.stream()
        .allMatch(e -> e.getSalary() > 30000);
```

---

# 21. Check if Any Employee Belongs to HR

```java
boolean result = employees.stream()
        .anyMatch(e -> e.getDepartment().equals("HR"));
```

---

# 22. Partition Employees Based on Salary > 50000

```java
Map<Boolean, List<Employee>> map = employees.stream()
        .collect(Collectors.partitioningBy(
                e -> e.getSalary() > 50000
        ));
```

---

# 23. Find Department Having Highest Average Salary

```java
Map.Entry<String, Double> result =
employees.stream()
        .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
        ))
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .orElse(null);
```

---

# 24. Find Youngest Employee in Each Department

```java
Map<String, Optional<Employee>> map =
employees.stream()
        .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.minBy(
                        Comparator.comparing(Employee::getAge)
                )
        ));
```

---

# 25. Group Employees by Gender

```java
Map<String, List<Employee>> map =
employees.stream()
        .collect(Collectors.groupingBy(Employee::getGender));
```

---

# 26. Get Comma Separated Employee Names

```java
String names = employees.stream()
        .map(Employee::getName)
        .collect(Collectors.joining(", "));
```

---

# 27. Find Employees Earning More Than Average Salary

```java
double avg = employees.stream()
        .mapToDouble(Employee::getSalary)
        .average()
        .orElse(0);

employees.stream()
        .filter(e -> e.getSalary() > avg)
        .forEach(System.out::println);
```

---

# 28. Find Nth Highest Salary Employee

```java
int n = 3;

Employee emp = employees.stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .skip(n - 1)
        .findFirst()
        .orElse(null);
```

---

# 29. Parallel Stream Example

```java
employees.parallelStream()
        .forEach(System.out::println);
```

---

# Most Asked Theory Questions

## Stream API Basics

* What is Stream API?
* Difference between Collection and Stream
* Why streams are lazy?
* Can stream be reused?
* Internal iteration vs external iteration

---

## Intermediate Operations

* filter()
* map()
* flatMap()
* sorted()
* distinct()
* limit()
* skip()

---

## Terminal Operations

* collect()
* reduce()
* forEach()
* count()
* findFirst()
* findAny()
* anyMatch()
* allMatch()

---

# Important Interview Differences

## map() vs flatMap()

| map()                               | flatMap()               |
| ----------------------------------- | ----------------------- |
| One-to-one mapping                  | One-to-many mapping     |
| Returns Stream<Stream<T>> sometimes | Flattens nested streams |

---

## findFirst() vs findAny()

| findFirst()           | findAny()                   |
| --------------------- | --------------------------- |
| Returns first element | Returns any element         |
| Deterministic         | Better for parallel streams |

---

## groupingBy() vs partitioningBy()

| groupingBy()            | partitioningBy()              |
| ----------------------- | ----------------------------- |
| Multiple groups         | Only 2 groups                 |
| Returns Map<K, List<T>> | Returns Map<Boolean, List<T>> |

---

## reduce() vs collect()

| reduce()            | collect()         |
| ------------------- | ----------------- |
| Immutable reduction | Mutable reduction |
| Sum/Product         | List/Map creation |

---

# Most Frequently Asked Real Interview Questions

* Second highest salary employee
* Highest salary by department
* Average salary by department
* Group employees by department
* Find duplicate elements
* Top N records
* Employees greater than average salary
* Sorting using Comparator
* map vs flatMap
* Stream lifecycle
* Parallel stream
* Optional class usage

---

# Parallel Stream Interview Questions

## Difference Between stream() and parallelStream()

| stream()              | parallelStream()                     |
| --------------------- | ------------------------------------ |
| Sequential processing | Multi-threaded processing            |
| Single thread         | ForkJoinPool                         |
| Better for small data | Better for large CPU-intensive tasks |

---

# When NOT to Use Parallel Stream

* Small dataset
* Shared mutable state
* Database calls
* File I/O operations
* Order-sensitive operations

---

# Bonus Advanced Questions

## Find Highest Salary Using reduce()

```java
Employee emp = employees.stream()
        .reduce((e1, e2) ->
                e1.getSalary() > e2.getSalary() ? e1 : e2)
        .orElse(null);
```

---

## Convert List to Map

```java
Map<Integer, String> map = employees.stream()
        .collect(Collectors.toMap(
                Employee::getId,
                Employee::getName
        ));
```

---

## Find Employees Count

```java
long count = employees.stream().count();
```

---

## Remove Duplicate Names

```java
employees.stream()
        .map(Employee::getName)
        .distinct()
        .forEach(System.out::println);
```

---

# Interview Tip

Most companies ask combinations of:

* Streams
* Comparator
* Optional
* Collectors
* groupingBy()
* map vs flatMap
* Sorting
* Top N Problems
* Duplicate handling
* Aggregation

Practice these questions multiple times without seeing answers.

```
```
