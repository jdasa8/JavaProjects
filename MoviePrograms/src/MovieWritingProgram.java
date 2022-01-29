import java.io.File;
// Imports File/IO which allows for external files to be used in our program
import java.io.FileNotFoundException;
// Imports FileNotFoundException which allows us to use an error exception that checks to see if the file exists or not
import java.io.PrintStream;
// Imports PrintStream which allows us to write to an external file
import java.util.Scanner;
// Imports Scanner which allows us to get user input

public class MovieWritingProgram {
// Creates a class called MovieWritingProgram
// Cannot run Java code without a class
	
	static int loop;
	static int year;
// Making two integer variables which are undeclared and static which allows them to be used anywhere in the entire file
	static boolean checker = false;
// Making a boolean variable that stores a true or false value
	
	public static void main(String args[]) throws FileNotFoundException{
// Main method; Java only runs things inside of the main method
// The throws keyword declares that this error may occur which in this case is a FileNotFoundException which is when the file does not exist		
		
		File file = new File("C:/Users/Jagadish/Desktop/Projects/mymovielist.txt");
// Creates a File variable called file
// Allows for an external file to be used in our program
		PrintStream stream = new PrintStream(file);
// Makes a PrintStream variable called stream which will allow us to write to a file
// It takes a parameter of the file which you want to write to
		Scanner scan = new Scanner(System.in);
// Creates a Scanner variable to get user input
		
		stream.printf("%-40s%-40s%-40s", "Movie", "Year", "Genre");
// Prints Movie, Year, and Genre formatted to be 40 spaces after each word to the txt file
		
		do {
// Do while loop; executes the block of code inside the do parameters before checking for the condition
			
		System.out.println("This program will add movies to your movie list!\nPlease enter the movie: ");
// Prints out a line of text on the screen and then moves to the next line
// \n moves to the next line before printing out the text after it
		String movieName = scan.nextLine();
// Creates a String variable called movieName and sets it equal to the line the user inputs
		String nameReplace = movieName.replace(' ', '_');
// Creates a String variable called nameReplace and sets it equal to movieName with the spaces replaced with an underscore
// This is done to make the movie name in the text file one word
		

		System.out.println("Please enter the year the movie was released: ");
		
		do {
			if(scan.hasNextInt()) {
// Will check to see if the user has inputted and integer

		year = scan.nextInt();
// Will set the integer variable year equal to the integer the user inputs
		checker = true;
// Sets the checker variable equal to true
			} else {
// Else condition which will run if the if condition is not met
				System.out.println("Please enter a year!");
				checker = false;
// Sets the checker variable equal to false
				scan.next();
			}
		} while(checker==false);
// While condition for this do while loop; will run the code over and over while checker variable is equal to false
		System.out.println("Please enter the genre of your movie: ");
		String genre = scan.next();
// Creates a String variable called genre and sets it equal to the next word inputted by the user
		
		stream.printf("\n%-40s%-40s%-40s", nameReplace, year, genre);

		Loop(scan);
// Calls a method called Loop outside the main method which has a parameter
		
		
		}while(loop == 1);
		
		System.out.println("Thank you for using the program!");
		
		}
	
// The Loop method will ask the user to loop through the program
	public static void Loop(Scanner sc) {
// Creates a method called Loop that has no return value and takes a parameter of a Scanner variable
		try {
// Try catch statement; tries to run the block of code inside of the try and if it has any errors it runs the code inside of the catch statement instead of giving a default error message
			System.out.println("Would you like to enter another movie? (Enter 1 for yes or anything else for no): ");
			loop = sc.nextInt();
			sc.nextLine();
			} catch (Exception e) {
// Catch; will run if the try has errors
				loop = 2;
			}
	}
	
}
