import java.io.File;
// Imports File/IO which allows for external files to be used in our program
import java.io.FileNotFoundException;
// Imports FileNotFoundException which allows us to use an error exception that checks to see if the file exists or not
import java.util.Formatter;
// Imports Formatter which allows us to format text in our program
import java.util.Scanner;
// Imports the Scanner which allows us to get user input or scan through a file

public class MovieReadingProgram {
// Creates a class called MovieReadingProgram
// Cannot run Java code without a class

	public static void main(String args[]) throws FileNotFoundException{
// Main method; Java only runs code within this method and all files and methods outside have to be called in the main method to be used
		
		Formatter fmt = new Formatter();
// Creates a Formatter variable called fmt which allows us to format text in the program
		
		fmt.format("%-30s%-30s%-30s\n", "Movie", "Year", "Genre");
// The words Movie, Year, and Genre are formatted such that there is 30 spaces after each word and it moves to the next line after printing it out
		
		String movieName;
// Creates a String variable called movieName which is not initialized 
// Strings hold strings of characters and words
		int year;
// Creates an integer variable called year which is not initialized
		String genre;
		
		File file = new File("C:/Users/Jagadish/Desktop/Projects/movielist.txt");
// Creates a File variable called file
// Allows for an external file to be used in our program
		Scanner scan = new Scanner(file);
// Creates a Scanner variable which will read through the file
		Scanner sc = new Scanner(System.in);
// Creates a Scanner variable which will get input from the user
		
		while(scan.hasNext()) {
// This loop will run as long as there are words in the txt file
			movieName = scan.next();
// Sets the String variable movieName to the next word in the txt file
			year = scan.nextInt();
// Sets the integer variable year equal to the next integer in the txt file
			genre = scan.next();
			
			String movreplace = movieName.replace('_', ' ');
// Creates a String variable called movreplace and sets it equal to movieName with the underscores replaced with a blank space
			
			format(movreplace, year, genre, fmt);
// Calls the format method made outside the main which takes 4 parameters
		}
		
		System.out.println(fmt);
// Prints out the formatted text
		
	}
	
// This method will format the text in the file being read 
	public static void format(String movie, int year, String genre, Formatter fmt) {
// Creates a method called format which does not have a return value and takes 2 String parameters, an integer parameter, and a Formatter variable
		
		fmt.format("%-30s%-30d%-30s\n", movie, year, genre);
		
	}
	
}
