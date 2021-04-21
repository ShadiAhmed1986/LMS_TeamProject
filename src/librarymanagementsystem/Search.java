package librarymanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Search extends BookVariables{
	
		Scanner scan=new Scanner(System.in);
			
		//Method to start searching by choosing option
	  	public void chooseAnOption() {
	  	System.out.println("======= Please choose a way to search =======");
	  	System.out.println();
	  	System.out.println("Press 1 to search by book name.");
	  	System.out.println("Press 2 to search by author name.");
	  	System.out.println("Press 3 to search by genre.");
	  			
	  	try {
	  		Scanner scan = new Scanner(System.in);
	  		int userChoice = scan.nextInt();
	  			
	  		switch(userChoice) {
	  		case 1:
	  			searchBook();
	  			break;
	  		case 2:
	  			searchByAuthor();
	  			break;
	  		case 3:
	  			searchByGenres();
	  			break;
	  		default:
	  			System.out.println("Please enter a valid input");
	  			chooseAnOption();
	  		}	
	  		scan.close();
	  	}catch(Exception e) {
	  		System.out.println("Invalid input, please try again !");
	  		chooseAnOption();
	  		   }
	  	}
	    
		public  void searchBook() {
		//As a user , I should be able to search a book by author name, book name, by genre.
		
		HashMap<String, String> bookDatabase = new HashMap<>();
			
		bookDatabase.put("101", "Harry Potter / J. K. Rowling / Fantasy");			
		bookDatabase.put("102", "Fantastic Mr Fox / Roald Dahl / Fantasy");
		bookDatabase.put("103", "The Witches / Roald Dahl / Fantasy");
		bookDatabase.put("104", "The Magic Finger Roald Dahl Fantasy Middle Fiction");
		bookDatabase.put("105", "The Ice Monster David Walliams Middle Fiction");
		bookDatabase.put("106", "Code Name Bananas David Walliams Middle Fiction");
		bookDatabase.put("107", "Bad Dad David Walliams Middle Fiction");
		bookDatabase.put("108", "The Witches Roald Dahl Fantasy");
		bookDatabase.put("109", "The Magic Finger Roald Dahl Fantasy Middle Fiction");
		bookDatabase.put("110", "The Ice Monster David Walliams Middle Fiction");	
		
			
		System.out.println("Please enter book name");
	    setBookName(scan.next().toUpperCase());
		int counter=0;
		for( Map.Entry<String, String>  w:bookDatabase.entrySet()) {
			if(w.getValue().toUpperCase().contains(getBookName())) {
				System.out.println("The book is in our database.");
				System.out.println( "SNN number is: " +w.getKey() +" Book Information is: " + w.getValue());
					 
			}else {
				counter++;
			}
					 
			 }
			if(counter==bookDatabase.size()) {
				System.out.println("We coud not find the book in Database");
				System.out.println("Please enter q to quit");
			String exit=scan.next();
			if(exit.equalsIgnoreCase("q")) {
				System.out.println("Thank you have a nice day.");
						 
				}
			}
		}
		
		public  void searchByAuthor() {
		//As a user , I should be able to search a book by author name, book name, by genre.
		
		HashMap<String, String> bookDatabase = new HashMap<>();
		List<String>list=new ArrayList<>();
		bookDatabase.put("101", "Harry Potter / J. K. Rowling / Fantasy");			
		bookDatabase.put("102", "Fantastic Mr Fox / Roald Dahl / Fantasy");
		bookDatabase.put("103", "The Witches / Roald Dahl / Fantasy");
		bookDatabase.put("104", "The Magic Finger Roald Dahl Fantasy Middle Fiction");
		bookDatabase.put("105", "The Ice Monster David Walliams Middle Fiction");
		bookDatabase.put("106", "Code Name Bananas David Walliams Middle Fiction");
		bookDatabase.put("107", "Bad Dad David Walliams Middle Fiction");
		bookDatabase.put("108", "The Witches Roald Dahl Fantasy");
		bookDatabase.put("109", "The Magic Finger Roald Dahl Fantasy Middle Fiction");
		bookDatabase.put("110", "The Ice Monster David Walliams Middle Fiction");
			
	
		System.out.println("Please enter author name");
		setAuthorName(scan.next().toUpperCase());
		int counter=0;
		for( Map.Entry<String, String>  w:bookDatabase.entrySet()) {
			if(w.getValue().toUpperCase().contains(getAuthorName())) {
					list.add(w.getValue());
	 
			}else {
					counter++;
			}
					 
		}
			if(list.size()==0) {
				System.out.println("We could not find the Author book");
			}else {
				System.out.println( getAuthorName() + " are in our database: ");
				System.out.println(list); 
			}
				
			if(counter==bookDatabase.size()) {
				System.out.println("Please enter q to quit");
				String exit=scan.next();
			if(exit.equalsIgnoreCase("q")) {
				System.out.println("Thank you have a nice day");
						 
				}
			}
			}
		
		public  void searchByGenres() {
		//As a user , I should be able to search a book by author name, book name, by genre.					 ​
		HashMap<String, String> bookDatabase = new HashMap<>();
		List<String>list=new ArrayList<>();
						
		bookDatabase.put("101", "Harry Potter J. K. Rowling Fantasy");
		bookDatabase.put("102", "Fantastic Mr Fox Roald Dahl Fantasy");
		bookDatabase.put("103", "The Witches Roald Dahl Fantasy");
		bookDatabase.put("104", "The Magic Finger Roald Dahl Fantasy Middle Fiction");
		bookDatabase.put("105", "The Ice Monster David Walliams Middle Fiction");
		bookDatabase.put("106", "Code Name Bananas David Walliams Middle Fiction");
		bookDatabase.put("107", "Bad Dad David Walliams Middle Fiction");
		bookDatabase.put("108", "The Witches Roald Dahl Fantasy");
		bookDatabase.put("109", "The Magic Finger Roald Dahl Fantasy Middle Fiction");
		bookDatabase.put("110", "The Ice Monster David Walliams Middle Fiction");

		System.out.println("Please enter genre:");
		setGenres(scan.next().toUpperCase());
		int counter=0;
		for( Map.Entry<String, String>  w:bookDatabase.entrySet()) {
			if(w.getValue().toUpperCase().contains(getGenres())) {
									 
					list.add(w.getValue());
	 
			}else {
					counter++;
				}
								 
		}
		if(list.size()==0) {
			System.out.println("We could not find this genre in our database.");
		}else {
			System.out.println(getGenres()+" books in our database : ");
			System.out.println(list); 
		}
							
		if(counter==bookDatabase.size()) {
			System.out.println("Please enter q to exist");
			String exit=scan.next();
		if(exit.equalsIgnoreCase("q")) {
			System.out.println("Thank you have a nice day");
									 
		}
		}		 
			
	}

}


