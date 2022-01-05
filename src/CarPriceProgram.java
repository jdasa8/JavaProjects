// Jagadish Dasa

import java.util.Scanner;
// Imports the scanner which allows us to get user input in the program
import java.text.NumberFormat;
// Imports NumberFormat which allows us to change the format of numbers in the program

public class carPriceProgram {
// Creates a class called carPriceProgram
// You need to create a class to run a Java program

	static String make;
	static String model;
// String variables store words and sentences
	static double price;
	static double HST;
// Double variables store decimal numbers
	static int repeat;
// Int variables store integers
// Initialized all the variables up here which will have a value set later on when needed in the program
// Static means that the variable can be accessed in this whole file only and it stays in memory until the program ends
	
	public static void main(String args[]) {
// Main method which is needed because if your program is not written or called in the main method it won't run
		
		Scanner scan = new Scanner(System.in);
// Creating a scanner variable which is used to get user input
		
		System.out.println("This program will calculate the total price of your car.");
// Prints out text on the screen. In this case it is printing out what the program is for so the user knows
		
		do {
// Do while loop where in between in the do curly brackets, it does the program once before checking the condition
			
		System.out.println("Enter the make of your car: ");
		make = scan.next();
// Gets user input and stores it in the variable make
		
		System.out.println("Enter the model of your " + make + ":");
		model = scan.next();
		
		System.out.println("Enter the price of your " + make + " " + model + ":");
		price = scan.nextDouble();
		
		System.out.println("Enter the HST rate in your province: (e.g. For 13% type \"13\")");
		HST = scan.nextDouble()/100;
// Gets user input and divides it by a 100 before storing it in the HST variable
// The purpose of this in this program is to convert the whole number the user enters into a decimal so it can be used as a percentage
		
		System.out.println("There will be a 2% Pre-Delivery Inspection Charge.\n");
		
		Total();
// Calling the method Total so that it can run
		
		try {
// Try catch statement; inside of the try curly brackets it tries the code and if there are any errors then it moves on to the catch statement 
		
		System.out.println("Would you like to check the total price of another car? (For yes type 1 otherwise type anything)");
		if(scan.hasNextInt()) {
// Checks to see if what the user inputed is an Integer
			
			repeat = scan.nextInt();
// Sets the repeat variable equal to the integer entered by the user
			
		} else {
			
			repeat = 2;
// Sets the repeat variable equal to 2 which means the program will not run again
			
		}
		
		} catch (Exception e) {
// This is what will run if there are any errors in the code within the curly brackets of try
			
			System.out.println();
		
		}
		
		} while(repeat == 1);
// The condition to keep running the program
		
		System.out.println("Thank you for using the program!");
		
		scan.close();
// Closes the scanner so it cannot be used again
		
	}
	
	public static void Total() {
// Makes a method called Total which will calculate the total amount for the car
		
		double tax = price*HST;
// Sets decimal variable tax equal to price variable multiplied by HST variable
		double total = (price * 1.02) + tax;
// Sets decimal variable total equal to price multiplied by 1.02 which is the Pre-Delivery Inspection charge of 2 percent plus tax
		
		NumberFormat nf = NumberFormat.getNumberInstance();
// Creates a NumberFormat variable that allows us to format numbers
		nf.setGroupingUsed(true);
// Adds commas to long numbers (e.g. 12,000)
		nf.setMaximumFractionDigits(2);
// Makes the amount of decimal places that a number can have to 2 decimal places
		String totalPrint = nf.format(total);
// Creates a string variable called totalPrint and stores the formatted version of the total variable in it
	
		System.out.println("The total amount for the car will be $" + totalPrint);
	
	}
	
}
