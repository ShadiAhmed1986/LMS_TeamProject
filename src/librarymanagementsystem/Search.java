package librarymanagementsystem;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Search{

	public static void main(String[] args) {
		
		HashMap<String, String> bookDatabase = new HashMap<>();
		
		bookDatabase.put("To Kill a Mockingbird","Harper Lee");
		bookDatabase.put("Go Set A Watchman","Harper Lee");
		bookDatabase.put("1984","George Orwell");
		bookDatabase.put("Harry Potter and the Philosopher’s Stone","J.K. Rowling");
		bookDatabase.put("The Lord of the Rings","J.R.R. Tolkien");
		bookDatabase.put("The Great Gatsby","F. Scott Fitzgerald");
		bookDatabase.put("Pride and Prejudice","Jane Austen");
		bookDatabase.put("The Diary Of A Young Girl","Anne Frank");
		bookDatabase.put("The Book Thief","Markus Zusak");
		bookDatabase.put("The Hobbit","J.R.R. Tolkien");
		bookDatabase.put("Little Women","Louisa May Alcott");
			
		chooseAnOption(bookDatabase);
		
	}
	
	//Method to start searching by choosing option
	public static void chooseAnOption(HashMap<String, String> bookDatabase) {
		System.out.println("======= Please choose a way to search =======");
		System.out.println();
		System.out.println("Press 1 to search by keyword.");
		System.out.println("Press 2 to search by author name.");
		System.out.println("Press 3 to search by book name.");
		
	try {
		Scanner scan = new Scanner(System.in);
		int userChoice = scan.nextInt();
		
		switch(userChoice) {
		case 1:
			searchByKeyword(bookDatabase);
			break;
		case 2:
			searchByAuthorName(bookDatabase);
			break;
		case 3:
			searchByBookName(bookDatabase);
			break;
		default:
			System.out.println("Please enter a valid input");
			chooseAnOption(bookDatabase);
		}	
		scan.close();
	}catch(Exception e) {
		System.out.println("Invalid input, please try again !");
		chooseAnOption(bookDatabase);
	    }
	}
	
	//Method to check if the input from user contains symbols only
		public static boolean checkIfInputSymbolsOnly(String str) {
			String specChar = "!@#$%^&*()_+.,[]'}{-\\\"";
			int counter = 0;
			for (int i = 0; i < str.length(); i++) {
				if(specChar.contains(str.substring(i, i+1))) {
					counter++;
				}
			}
			if(str.length()==counter) {
				return true;
			}
			return false;
		}
	
	//To search by a random keyword
	public static void searchByKeyword(HashMap<String, String> bookDatabase) {
		boolean isInDatabase = false;
		
		System.out.println("Please enter keyword to search !");
		Scanner scan = new Scanner(System.in);
		String bookNameOrAuthorName = scan.next().toLowerCase();
		
		if(bookNameOrAuthorName.length() > 2 && !checkIfInputSymbolsOnly(bookNameOrAuthorName)) {
			for (Entry<String,String> w : bookDatabase.entrySet()) {
				if(w.getKey().toLowerCase().contains(bookNameOrAuthorName) || w.getValue().toLowerCase().contains(bookNameOrAuthorName)) {
					System.out.println(w.getKey() + " by " + w.getValue());
					isInDatabase = true;
				}
			}
			if(!isInDatabase) {
				System.out.println("We don't have any records for the word you are looking for."
						+ "\nDo you want to report it ?");
			}
		}else {
			System.out.println("Your input is too short or contains symbols only. Please try again !");
			System.out.println();
			searchByKeyword(bookDatabase);
		}		
		scan.close();
	}
	
	//To search by author name
	public static void searchByAuthorName(HashMap<String, String> bookDatabase) {
		boolean isInDatabase = false;
		
		System.out.println("Please enter an author name!");
		Scanner scan = new Scanner(System.in);
		String authorName = scan.next().toLowerCase();
		
		if(authorName.length() > 2 && !checkIfInputSymbolsOnly(authorName)) {
			for (Entry<String,String> w : bookDatabase.entrySet()) {
				if(w.getValue().toLowerCase().contains(authorName)) {
					System.out.println(w.getKey());
					isInDatabase = true;
				}
			}
			if(!isInDatabase) {
				System.out.println("We don't have any records for this author or this is not a correct author name."
						+ "\nDo you want to report it ?");
			}
		}else {
			System.out.println("Your input is too short or contains symbols only. Please try again !");
			System.out.println();
			searchByAuthorName(bookDatabase);
		}	
		scan.close();
	}
	
	//To search by book name
	public static void searchByBookName(HashMap<String, String> bookDatabase) {
		boolean isInDatabase = false;
		
		System.out.println("Please enter a book name!");
		Scanner scan = new Scanner(System.in);
		String bookName = scan.next().toLowerCase();
		
		if(bookName.length() > 2 && !checkIfInputSymbolsOnly(bookName)) {
			for (Entry<String,String> w : bookDatabase.entrySet()) {
				if(w.getKey().toLowerCase().contains(bookName)) {
					System.out.println(w.getKey() + " by " + w.getValue());
					isInDatabase = true;
				}
			}
			if(!isInDatabase) {
				System.out.println("We don't have any records for this book."
						+ "\nDo you want to report it ?");
			}
		}else {
			System.out.println("Your input is too short or contains symbols only. Please try again !");
			System.out.println();
			searchByBookName(bookDatabase);
		}	
		scan.close();
	}
	
}
