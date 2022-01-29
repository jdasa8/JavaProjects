import java.io.File;
// Allows us to work with a file in our program
import java.io.FileNotFoundException;
// Allows us to use an error exception which looks at if the file exists or not
import java.util.Scanner;
// Imports the Scanner which allows us to get user input in the program

public class MovieSearchingProgram {
// Making a Java class called MovieSearchingProgram
// Without a class we cannot have our java code run
	
	public static void main(String[] args) throws FileNotFoundException {
// Main method
// Java only runs code within the main method and any code written outside it has to be called inside.
// Throws FileNotFoundException declares that the FileNotFoundException may occur in the program
// FileNotFoundException is an error where the file trying to be accessed by the program does not exist
		
		System.out.println("Welcome! This program will filter your results from your movie file.");
		System.out.println("--------------------------------------------------------------------");
// Prints two lines of text; one which explains what the program is about and the other separates the text from the rest of the text
		
		String searchInfo = getInfo();
// Creates a String variable called searchGenre which holds a string of text and sets it equal to the return value of a method called getInfo
		File file = new File("C:/Users/Jagadish/Desktop/Projects/mymovielist.txt");
// Creates a File variable called file which allows for an external file to be used in the program; in this case the movielist file which will be searched through
		Scanner input = new Scanner(file);
// Creates a Scanner variable which will read through the file
		
		String Ln = searchInfo(input, searchInfo);
// searchInfo is a created method which requires variables in the parameters
		int match = 0;
// Creates an Integer variable called match and sets it equal to 0
// This variable will later on be used to show the amount of matches to the keyword the user inputs
		
		if (Ln.length() > 0) {
// Checks if the length of each line in the text file is more than 0	
			
			System.out.printf("\n%-30s%-30s%-30s\n", "Movie", "Year", "Genre");
// Prints the words "Movie", "Year", and "Genre" in a formatted way where there's 30 spaces after each word
// \n moves to the next line			
			
			while (Ln.length() > 0) {
// Runs a block of code as long as the line being read from the file is greater than 0
				
				match+=1;
// Adds 1 to the initial value of the match variable each time
				showInfo(Ln);
// Calling the showInfo method to run the contents of that method
// Takes a parameter
				Ln = searchInfo(input, searchInfo);
// Sets the Ln variable to the return value of the searchInfo method
			
			}
		}
		
// These if and else statements will print something different depending on the value of match to make sure the sentence being printed is grammatically correct
		if (match > 1) {		
			
			System.out.println("\nThere were " + match + " matches!");
		
		}
		
		else if (match == 1) {
		
			System.out.println("\nThere was " + match + " match!");
		
		} else {
			
			System.out.println("\nThere were no matches");
		
		}
		
	}

// This method getInfo will get the user input and return it
	public static String getInfo() {
// Creates a method called getInfo which will return a String and has no parameters
		
		System.out.print("Please enter a movie, year, or genre to filter results.\n\n");
		Scanner sc = new Scanner(System.in);
// Creates a Scanner variable to get user input
		String searchInfo = sc.next();
// Will set the String variable searchInfo to the next word the user inputs
		String lowerSearchInfo = searchInfo.toLowerCase();
// Makes a String variable called lowerSearchInfo which will be equal to the searchInfo variable but formatted to be lower case characters only
				
		return lowerSearchInfo;
// Method returns the String variable lowerSearchInfo
		
	}

// This method searchInfo will search the txt file
	public static String searchInfo(Scanner sc, String searchInfo) {
// Method has two parameters; one is a Scanner variable and the other is a String
// These variables will be referred to as sc and searchInfo within the method
		
		while (sc.hasNextLine()) {
// Will run the loop as long as there is text in the file
		
		String line = sc.nextLine();
// Sets the String variable line equal to the line of text that is read each time from the file
		String lowerLine = line.toLowerCase();
		
		if (lowerLine.indexOf(searchInfo) >= 0) {
// Checks if the index of where the searchInfo String is in the lowerLine string is greater than or equal to 0
		
			return line;
		
		}
	}
	return "";
// Returns this if the if condition is not met
}

// This method is to show the search results
	public static void showInfo(String ln) {
// A method that does not return anything since it is void
		
		Scanner LnSc = new Scanner(ln);
		String movie = LnSc.next();
		int year = LnSc.nextInt();
// Will set the integer variable year equal to the integer which is gotten from the file
		String genre = LnSc.next();
		
		String movReplace = movie.replace('_', ' ');
// Will create a new String variable which will replace all the underscores in the movie variable with white spaces
		
		System.out.printf("%-30s%-30s%-30s\n", movReplace, year, genre);
	
	}
	
}
