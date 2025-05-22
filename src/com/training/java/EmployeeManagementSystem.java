package com.training.java;

//Interface for Salary Calculation
interface SalaryPayable {
	double calculateSalary();
}

//Abstract base class
abstract class Employee {
	protected int id;
	protected String name;
	protected String department;

	public Employee(int id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public abstract void displayInfo(); // Abstract method
}

//Derived class 1
class PermanentEmployee extends Employee implements SalaryPayable {
	private double monthlySalary;

	public PermanentEmployee(int id, String name, String department, double monthlySalary) {
		super(id, name, department);
		this.monthlySalary = monthlySalary;
	}

	// Method overriding
	@Override
	public void displayInfo() {
		System.out.println("Permanent Employee - ID: " + id + ", Name: " + name + ", Dept: " + department);
	}

	// Method from interface
	public double calculateSalary() {
		return monthlySalary;
	}
}

//Derived class 2
class ContractEmployee extends Employee implements SalaryPayable {
	private double hourlyRate;
	private int hoursWorked;

	public ContractEmployee(int id, String name, String department, double hourlyRate, int hoursWorked) {
		super(id, name, department);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	@Override
	public void displayInfo() {
		System.out.println("Contract Employee - ID: " + id + ", Name: " + name + ", Dept: " + department);
	}

	public double calculateSalary() {
		return hourlyRate * hoursWorked;
	}
}

public class EmployeeManagementSystem {
	// Method Overloading
	public static void printGreeting() {
		System.out.println("Welcome to Employee Management System");
	}

	public static void printGreeting(String dept) {
		System.out.println("Welcome to " + dept + " Department");
	}

	public static void main(String[] args) {
		printGreeting();
		printGreeting("Human Resources");

		Employee e1 = new PermanentEmployee(201, "Rahul", "Finance", 50000);
		Employee e2 = new ContractEmployee(202, "Nina", "Tech Support", 500, 40);

		e1.displayInfo();
		e2.displayInfo();

		System.out.println("Salary of " + e1.name + ": ₹" + ((SalaryPayable) e1).calculateSalary());
		System.out.println("Salary of " + e2.name + ": ₹" + ((SalaryPayable) e2).calculateSalary());
	}
}
