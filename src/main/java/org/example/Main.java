package org.example;

import java.util.List;

public class Main {
    // Java Record: Getter, Constructor, equals() ve hashCode()
    public record Employee(String name, String department, double salary) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Taha", "Backend Engineering", 75000),
                new Employee("Ahmet", "Frontend", 45000),
                new Employee("Lina", "Backend Engineering", 82000),
                new Employee("Mehmet", "HR", 40000)
        );

        System.out.println("--- Salary 50.000 Over than Backend Engineers ---");

        // Inplace of Classic for/if , formal Java Stream API using:
        employees.stream()
                .filter(e -> e.department().equals("Backend Engineering"))
                .filter(e -> e.salary() > 50000)
                .map(Employee::name)
                .forEach(System.out::println);
    }
}