// Jagadish Dasa

import java.util.Scanner;
// Imports the Scanner so that it can be used in the program
import java.text.NumberFormat;
// Imports NumberFormat which allows you to format numbers in different ways so that it can be used in the program
public class CarSpeedProgram{
// Creates a class named CarSpeedProgram. You cannot make a Java program without a class

	static double distancekm;
	static double timehr;
	static double speed;
	static int x;
	static int choice;
// Initializing variables that will be used later in the program. 
// Double is a decimal number and int is an integer. 
// Static means that the variable can be accessed in this whole file only and it stays in memory until the program ends.
	
	public static void main(String[] args){	
// Main method; anything you want ran in the program has to be either written in this method or called here
		
		NumberFormat nf = NumberFormat.getNumberInstance();
// Creating a Number Format variable so that I can format numbers in different ways in the program
		nf.setGroupingUsed(true);
// This adds commas to longer numbers (e.g. 13,000)
		nf.setMaximumFractionDigits(2);
// This sets the maximum number of decimal digits to 2 digits
		
	    Scanner scan = new Scanner(System.in);
// Creating a scanner variable so that it can be used throughout the program to take user input
	    
	    System.out.println("This program will calculate the average speed, distance, or time travelled of a car.");
// Prints out the text in quotations
	   
		do {	
// Do while loop that will run the code before checking for the condition
			System.out.println("\nEnter which you would like to calculate (s=1/d=2/t=3): ");
			choice = scan.nextInt();
// Gets user input for an integer and stores it in the choice variable
			
			if(choice == 1) {
// Checks the condition if the choice variable equals one and if it does then it runs this code

			System.out.println("Enter the distance travelled in km: ");
			distancekm = scan.nextDouble();
// Gets user input for a decimal number and stores it in the distancekm variable
				
			System.out.println("\nEnter the time in hours");
			timehr = scan.nextDouble();

			speed = distancekm/timehr;
// Sets the initialized variable speed to distancekm divided by timehr

			
			String nfSpeed = nf.format(speed);
// Creating a string variable that will store the speed with the formatted changes such as the commas and maximum number of decimals
			
			System.out.println("\nThe average speed is " + nfSpeed + " km per hour");
	
			conversionDistanceMeters(1);
			conversionDistanceMiles(1);
// Calling methods made outside the main method so that they can run
			
			} 
			
			else if (choice == 2) {
				
				System.out.println("Enter the time in hours: ");
				timehr = scan.nextDouble();
				
				System.out.println("\nEnter the speed in km/h: ");
				speed = scan.nextDouble();
				
				distancekm = speed*timehr;
// Sets the initialized variable distancekm to speed multiplied by time
				
				String nfDistance = nf.format(distancekm);
				
				System.out.println("\nThe distance travelled is " + nfDistance + " km");
				
				conversionDistanceMeters(2);
				conversionDistanceMiles(2);
			}
			
			else if (choice == 3) {
				
				System.out.println("Enter the speed in km/h: ");
				speed = scan.nextDouble();
				
				System.out.println("\nEnter the distance in km: ");
				distancekm = scan.nextDouble();
				
				timehr = distancekm/speed;
// Sets the initialized variable timehr equal to distancekm divided by speed
				
				String nfTime = nf.format(timehr);
				
				System.out.println("\nThe time taken is " + nfTime + " hour(s)");
				
				conversionDistanceMeters(3);
			}else {
// If the user does not input 1, 2, or 3 this code will run
				System.out.println("Please pick 1, 2, or 3 only.");
			}
			
			try {
// Try will try to run the code inside the curly brackets
			System.out.println("\nWould you like to calculate again? (Enter 1 for yes or anything else for no)");
			
			if(scan.hasNextInt()) {
// This is checking to see if the user input an Integer
				x=scan.nextInt();
// Sets the variable x equal to the Integer entered by the user
			} else {
				x = 2;
// Sets x equal to 2 if the user did not input an integer which means the program will not loop again
			}
			
			} catch(Exception e) {
// Catch will catch any errors in the try code and will do what's in the curly brackets if there are any errors
				System.out.println();
			}
			
		} while(x==1);
// Condition for the code above inside the do curly brackets to run again
		
		System.out.println("Thank you for using the program!");
		
		scan.close();
// Closes the scanner as it will not be used again
	}

	public static void conversionDistanceMeters(int x){
// Makes a method that requires a parameter of an integer when calling it
// This method is to convert the distance in km/h to meters/second
		
		double distance_m = distancekm*1000;
		double time_s = timehr * (60*60);
		double speed2 = distance_m/time_s;
		
		NumberFormat numf = NumberFormat.getNumberInstance();
		numf.setGroupingUsed(true);
		numf.setMaximumFractionDigits(2);
		String strSpeed = numf.format(speed2);
		String strDistance = numf.format(distance_m);
		String strTime = numf.format(time_s);
		
		 if (x == 1) {
		System.out.println("\nThe average speed in meters/second is " + strSpeed + " meters per second");
		 }
		 else if (x==2) {
			 System.out.println("\nThe distance travelled in meters is " + strDistance + " meters");
		 }
		 else {
			 System.out.println("\nThe time taken in seconds is " + strTime + " seconds");
		 }
		 }
	
	public static void conversionDistanceMiles(int y) {
// This method converts the distance from km/h to miles per hour
		
		double miles = distancekm*0.62137;
		double speedmiles = miles/timehr;
		
		NumberFormat numf = NumberFormat.getNumberInstance();
		numf.setGroupingUsed(true);
		numf.setMaximumFractionDigits(2);
		String strSpMiles = numf.format(speedmiles);
		String strMiles = numf.format(miles);
		
		if (y==1) {
		System.out.println("\nThe average speed in miles/hour is " + strSpMiles + " miles per hour");
		}
		else {
			System.out.println("\nThe distance travelled in miles is " + strMiles + " miles");
		}
		}
	
}
