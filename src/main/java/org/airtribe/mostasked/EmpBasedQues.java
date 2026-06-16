package org.airtribe.mostasked;

import java.util.*;
import java.util.stream.Collectors;

public class EmpBasedQues {

    List<Employee> employees = List.of(
            new Employee(1, "Aman", "IT", 60000, 25, "Male"),
            new Employee(2, "Riya", "HR", 50000, 28, "Female"),
            new Employee(8, "Neha", "HR", 50000, 28, "Female"),
            new Employee(3, "John", "IT", 70000, 30, "Male"),
            new Employee(4, "Sara", "Finance", 65000, 27, "Female"),
            new Employee(5, "Alex", "HR", 45000, 24, "Male"),
            new Employee(6, "Neha", "IT", 80000, 29, "Female"),
            new Employee(7, "Hiba", "IT", 80000, 29, "Female")
    );

    // Find Employee from IT Department
    void ITDepartmentEmployee() {
        employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .forEach(System.out::println);
    }

    // Find Employees Having Salary Greater Than 50,000
    void empWithSalaryGreaterThan50000() {
        employees.stream()
                .filter(emp -> emp.getSalary() > 50000)
                .forEach(System.out::println);
    }

    // Find Employee Between Age 25 and 35
    void empBetweenAge25And35() {
        employees.stream()
                .filter(emp -> emp.getAge() >= 25 && emp.getAge() <= 35)
                .forEach(System.out::println);
    }

    // Get All Employee Names
    void getAllEmployeeNames() {
        employees.stream()
                .map(employee -> employee.getName())
                .forEach(System.out::println);
    }

    // Convert Employee Names to Uppercase
    void empNamesInUppercase() {
        employees.stream()
                .map(emp -> emp.getName().toUpperCase())
                .forEach(System.out::println);
    }

    // Sort Employee by Salary Ascending
    void sortEmployeeBySalary() {
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .forEach(System.out::println);
    }

    // Sort Employee by Salary Descending
    void sortEmployeeBySalaryDesc() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);
    }

    // Sort Employees by Age then Name
    void sortEmployeeByAgeThenName() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge)
                        .thenComparing(Employee::getName))
                .forEach(System.out::println);
    }

    // Group Employees by Department
    void groupEmployeesByDepartment() {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((k, v) -> {
                    System.out.println(k+" - "+v);
                });
    }

    // Count Employees in Each Department
    void countEmployeesInEachDepartment() {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .forEach((k, v) -> {
                    System.out.println(k+" - "+v);
                });
    }

    // Find Average of Each Department
    void findAverageOfEachDepartment() {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)))
                .forEach((k, v) -> {
                    System.out.println(k+ " - "+v);
                });
    }

    public void highestPaidEmployeeInEachDept() {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .forEach((k, v) -> {
                    System.out.println(k+" - "+v.get());
                });
    }

    // Find Total Salary of Employees
    void totalSalaryOfEmployees() {
        double sumOfSalary = employees.stream()
                .reduce(0.0, (sum, emp) -> sum + emp.getSalary(), Double::sum);

        System.out.println("Total Salary - "+sumOfSalary);

    }

    // Find Average Salary
    void findTotalAverageSalary() {
        double avg = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.printf("Average Salary: %.2f", avg);
        System.out.println();
    }

    // Find Employee With Maximum Salary
    void empWithMaxSalary() {
        Employee emp = employees.stream()
                        .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);

        System.out.println("Max Salary Employee: "+emp);
    }

    // Find Youngest Employee
    void findYoungestEmployee() {
        Employee emp = employees.stream()
                .min(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
        System.out.println("Youngest Employee: "+ emp);
    }

    // Find Second-Highest Salary Employee
    void secondHighestEmployee() {
        Employee emp = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println("2nd Highest Salary: "+emp);
    }

    // Find the Top 3 Highest Paid Employees
    void highestTop3PaidEmployees() {
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    // Find Duplicate Employee Names
    void findDuplicateNames() {
//        Set<String> set = new HashSet<>();
//        employees.stream()
//                .map(Employee::getName)
//                .filter(name -> !set.add(name))
//                .forEach(System.out::println);

        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getName,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(key -> System.out.println(key));
    }

    // Check if All Employees Have Salary Greater Than 30000
    void checkSalaryAbove30000() {
        boolean res = employees.stream()
                .allMatch(emp -> emp.getSalary() > 30000);
        System.out.println("Salary Greater Than 30000: "+res);
    }

    // Check if Any Employee Belongs to HR
    void checkIfAnyEmployeeHR() {
        boolean isHrPresent = employees.stream()
                .anyMatch(emp -> emp.getDepartment().equals("HR"));
        System.out.println("Is HR Present: "+isHrPresent);
    }

    // Partition Employee Based on Salary > 50000
    void partitionWithSalaryGreater50000() {
        employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getSalary() > 50000))
                .forEach((k, v) -> {
                    System.out.println(k+" - "+v);
                });
    }

    // Find Department Having Highest Average Salary
    void departmentWithHighestAverageSalary() {
        Map.Entry<String, Double> entry = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)))
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .orElse(null);
        System.out.println("Department Highest Average Salary: "+entry.getKey()+" With Salary: "+entry.getValue());
    }

    // Find the Youngest Employee in Each Department
    void youngestEmployeeInEachDepartment() {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.minBy(Comparator.comparing(Employee::getAge))))
                .forEach((k, v) -> {
                    System.out.println(k+" -> "+v.get());
                });
    }

    // Group Employees by Gender
    void groupByGender() {
        employees.stream()
                .collect((Collectors.groupingBy(Employee::getGender)))
                .forEach((k, v) -> {
                    System.out.println(k+" - "+v);
                });
    }

    // Get Comma Separated Employees Names
    void commaSeparatedNames() {
        String str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println(str);
    }

    // Find Employees Earning More Than Average Salary
    void empEarnMoreThanAvgSalary() {
        double avgSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        employees.stream()
                .filter(e -> e.getSalary() > avgSalary)
                .forEach(System.out::println);
    }

    // Find Nth-Highest Salary Employee
    void nthHighestSalaryEmployee(int n) {
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(n-1)
                .limit(1)
                .forEach(System.out::println);
    }

    // Parallel Stream Example
    void parallelStream() {
        employees.parallelStream()
                .forEachOrdered(System.out::println);
    }
}
