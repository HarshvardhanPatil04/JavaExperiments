package Experiment3;

import java.util.Scanner;

// Parent class
class Employee {

    // Data members of Employee
    int empId;
    String name;
    double salary;

    // Method to take employee details from the user
    void getEmployeeDetails(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        empId = sc.nextInt();
        sc.nextLine(); // FIX: Clear leftover newline after nextInt()

        System.out.print("Enter Employee Name: ");
        name = sc.nextLine(); // FIX: nextLine() to support full names with spaces

        System.out.print("Enter Salary: ");
        salary = sc.nextDouble();
        sc.nextLine(); // FIX: Clear leftover newline after nextDouble()
    }

    // Method to display employee details
    void display() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }

    // Method Overloading - calculateSalary without bonus
    double calculateSalary() {
        return salary;
    }

    // Method Overloading - calculateSalary with bonus
    double calculateSalary(double bonus) {
        return salary + bonus;
    }
}

// Child class - inherits Employee
class Manager extends Employee {

    String department;
    double bonus;

    // Overriding getEmployeeDetails to also take department and bonus
    @Override
    void getEmployeeDetails(Scanner sc) {
        super.getEmployeeDetails(sc); // Calling parent method

        System.out.print("Enter Department: ");
        department = sc.nextLine(); // FIX: nextLine() to support full department names

        System.out.print("Enter Bonus: ");
        bonus = sc.nextDouble();
        sc.nextLine(); // FIX: Clear leftover newline after nextDouble()
    }

    // Overriding display method
    @Override
    void display() {
        super.display(); // Calling parent display
        System.out.println("Department: " + department);
        System.out.println("Manager manages the team.");
        System.out.println("Total Salary with Bonus: " + calculateSalary(bonus));
    }
}

// Main class
public class Experiment3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Manager m = new Manager();

        m.getEmployeeDetails(sc); // Taking input

        System.out.println("\nEmployee Details\n");
        m.display(); // Displaying details

        sc.close();
    }
}