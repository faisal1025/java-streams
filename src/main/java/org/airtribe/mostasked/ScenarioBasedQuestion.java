package org.airtribe.mostasked;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ScenarioBasedQuestion {
        /*
            Scenario-Based Question: Employee Data Analysis
            You have a list of Employee objects, each with properties like id, name, department
        */

    List<Employee> employees = List.of(
            new Employee(1, "Aman", "IT", 60000, 25, "Male"),
            new Employee(2, "Riya", "HR", 50000, 28, "Female"),
            new Employee(3, "John", "IT", 70000, 30, "Male"),
            new Employee(4, "Sara", "Finance", 65000, 27, "Female"),
            new Employee(5, "Alex", "HR", 45000, 24, "Male"),
            new Employee(6, "Neha", "IT", 80000, 29, "Female")
    );

    public static void main(String[] arg) {
        EmpBasedQues empQues = new EmpBasedQues();
        empQues.ITDepartmentEmployee();
        System.out.println("------------------------------------------");
        empQues.empWithSalaryGreaterThan50000();
        System.out.println("-------------------------------------------");
        empQues.empBetweenAge25And35();
        System.out.println("-------------------------------------------");
        empQues.getAllEmployeeNames();
        System.out.println("--------------------------------------------");
        empQues.empNamesInUppercase();
        System.out.println("---------------------------------------------");
        empQues.sortEmployeeBySalary();
        System.out.println("---------------------------------------------");
        empQues.sortEmployeeBySalaryDesc();
        System.out.println("---------------------------------------------");
        empQues.sortEmployeeByAgeThenName();
        System.out.println("---------------------------------------------");
        empQues.groupEmployeesByDepartment();
        System.out.println("---------------------------------------------");
        empQues.countEmployeesInEachDepartment();
        System.out.println("---------------------------------------------");
        empQues.findAverageOfEachDepartment();
        System.out.println("----------------------------------------------");
        empQues.highestPaidEmployeeInEachDept();
        System.out.println("---------------------------------------------");
        empQues.totalSalaryOfEmployees();
        System.out.println("----------------------------------------------");
        empQues.findTotalAverageSalary();
        System.out.println("----------------------------------------------");
        empQues.empWithMaxSalary();
        System.out.println("----------------------------------------------");
        empQues.findYoungestEmployee();
        System.out.println("----------------------------------------------");
        empQues.secondHighestEmployee();
        System.out.println("----------------------------------------------");
        empQues.highestTop3PaidEmployees();
        System.out.println("----------------------------------------------");
        empQues.findDuplicateNames();
        System.out.println("----------------------------------------------");
        empQues.checkSalaryAbove30000();
        System.out.println("----------------------------------------------");
        empQues.checkIfAnyEmployeeHR();
        System.out.println("----------------------------------------------");
        empQues.partitionWithSalaryGreater50000();
        System.out.println("----------------------------------------------");
        empQues.departmentWithHighestAverageSalary();
        System.out.println("----------------------------------------------");
        empQues.youngestEmployeeInEachDepartment();
        System.out.println("----------------------------------------------");
        empQues.commaSeparatedNames();
        System.out.println("----------------------------------------------");
        empQues.empEarnMoreThanAvgSalary();
        System.out.println("----------------------------------------------");
        empQues.nthHighestSalaryEmployee(3);
        System.out.println("----------------------------------------------");
        empQues.parallelStream();
    }

    // group employees by department
    public void groupByDepartment() {
        System.out.println("----------------------------Group Employee By Department----------------------------");
        Map<String, List<Employee>> departmentGroup = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getDepartment()));

        for(Map.Entry<String, List<Employee>> entry: departmentGroup.entrySet()) {
            System.out.println(entry.getKey()+" --> "+entry.getValue());
        }
    }

    // Find Highest Salary Employee
    public void highestSalaryEmployee() {
        System.out.println("-----------------------Highest Salary Employee------------------------------");
        Optional<Employee> highestSalaryEmployee = employees.stream()
                .max(Comparator.comparing(emp -> emp.getSalary()));
        if(highestSalaryEmployee.isEmpty()){
            System.out.println("No any record found");
        }else{
            Employee emp = highestSalaryEmployee.get();
            System.out.println("Highest Salary -->"+emp);
        }
    }

    // Find the highest salary employee in each department
    public void highestSalaryPerDepartment() {
        System.out.println("-------------------Highset Salary Per Department--------------------------");
        Map<String, Optional<Employee>> highSalaryPerDepartment = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getDepartment(),
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        highSalaryPerDepartment.forEach((key, val) -> {
            System.out.println(key+"-->"+val.get());
        });
    }

    // Find average salary per department
    public void avgSalaryPerDepartment(){
        System.out.println("------------------------Average Salary Per Department--------------------------");
        Map<String, Double> empDepartWithAvg = employees.stream().collect(
                Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary))
        );
        System.out.println(empDepartWithAvg);
    }

    // Count employees in each department
    public void cntEmployeeEachDepart() {
        System.out.println("------------------------Counting the Employee in Each Department---------------------");
        Map<String, Long> empCntPerDept = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.counting())
                );
        empCntPerDept.forEach((k, v) -> {
            System.out.println(k+" --> "+v);
        });
    }

    // Partition employees (salary > 60K)
    public void partitionBySalary() {
        System.out.println("-------------------------Partition Employee By Salary > 60----------------------");
        Map<Boolean, List<Employee>> partition = employees.stream()
                .collect(
                        Collectors.partitioningBy(emp -> emp.getSalary() > 60000)
                );
        System.out.println(partition);
    }

    // Sort employees by salary (descending)
    public void sortEmployeesBySalary() {
        System.out.println("------------------------Sort Employees By Salary-----------------------");
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).toList();
        System.out.println(String.join(", ", sortedEmployees.stream().map(emp -> String.valueOf(emp.getSalary())).toList()));
    }

    // Sort Employees by salary and then age
    public void sortEmployeesBySalaryAndAge() {
        System.out.println("------------------------Sort Employees By Salary and Age-----------------------");
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .sorted(Comparator.comparingInt(Employee::getAge))
                .toList();
        System.out.println(sortedEmployees);

    }
}
