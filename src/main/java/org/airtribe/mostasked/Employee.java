package org.airtribe.mostasked;

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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id + ", " +
                "name='" + name + '\'' + ", " +
                "department=" + department + ", " +
                "salary=" + salary + ", " +
                "gender=" + gender + ", " +
                "age=" + age + ", " +
                '}';
    }
}
