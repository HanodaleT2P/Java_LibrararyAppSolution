package com.training.java;

//Interface to calculate reading time
interface Readable {
	int calculateReadingTime(); // in minutes
}

//Abstract class
abstract class Book {
	protected String title;
	protected String author;
	protected String isbn;

	public Book(String title, String author, String isbn) { // Constructor
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public abstract void displayDetails(); // Abstract method
}

//Derived class 1: PrintedBook
class PrintedBook extends Book implements Readable {
	private int pages;

	public PrintedBook(String title, String author, String isbn, int pages) {
		super(title, author, isbn);
		this.pages = pages;
	}

	@Override
	public void displayDetails() {
		System.out.println("Printed Book - Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
	}

	@Override
	public int calculateReadingTime() {
		return pages * 2; // Assume 2 minutes per page
	}
}

//Derived class 2: EBook
class EBook extends Book implements Readable {
	private int fileSizeMB;

	public EBook(String title, String author, String isbn, int fileSizeMB) {
		super(title, author, isbn);
		this.fileSizeMB = fileSizeMB;
	}

	@Override
	public void displayDetails() {
		System.out.println("E-Book - Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
	}

	@Override
	public int calculateReadingTime() {
		return fileSizeMB * 5; // Assume 5 minutes per MB
	}
}

public class LibraryManagementSystem {
	// Method Overloading
	public static void printMessage() {
		System.out.println("Welcome to the Library!");
	}

	public static void printMessage(String section) {
		System.out.println("Welcome to the " + section + " section!");
	}

	public static void main(String[] args) {
		printMessage();
		printMessage("Fiction");

		Book b1 = new PrintedBook("Java Basics", "James Gosling", "1111", 300);
		Book b2 = new EBook("Python Guide", "Guido van Rossum", "2222", 10);

		b1.displayDetails();
		b2.displayDetails();

		System.out.println(
				"Estimated Reading Time for " + b1.title + ": " + ((Readable) b1).calculateReadingTime() + " minutes");
		System.out.println(
				"Estimated Reading Time for " + b2.title + ": " + ((Readable) b2).calculateReadingTime() + " minutes");
	}
}
