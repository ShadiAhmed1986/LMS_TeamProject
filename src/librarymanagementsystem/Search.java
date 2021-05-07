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
            System.out.println("== Please enter a valid input ==");
            chooseAnOption();
        }   
        scan.close();
    }catch(Exception e) {
        System.out.println("== Invalid input, please try again ! ==");
        chooseAnOption();
           }
    }
    
    public  void searchBook() {
    //As a user , I should be able to search a book by author name, book name, by genre.
        List<String>list=new ArrayList<>();
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
            
    System.out.println("== Please enter a book name ==");
    setBookName(scan.next().toUpperCase());
    int counter=0;
    for( Map.Entry<String, String>  w:bookDatabase.entrySet()) {
        if(w.getValue().toUpperCase().contains(getBookName())) {
            System.out.println("== The book is in our database. ==");
            System.out.println( "SNN number is: " +w.getKey() +" Book Information is: " + w.getValue());
            list.add(w.getValue());
        }else {
            counter++;
        }
                 
        }
            System.out.println("== Do you want to add the book to you basket?(yes/no) ==");
            String ass=scan.next();
            if(ass.equalsIgnoreCase("yes")) {
                selectAndAddBasket(list);
            }else {
                selectOption();
            }
        if(counter==bookDatabase.size()) {
            System.out.println("== We coud not find the book in Database ==");
            System.out.println("== Please enter q to quit ==");
        String exit=scan.next();
        if(exit.equalsIgnoreCase("q")) {
            System.out.println("== Thank you have a nice day. ==");                    
            }
        }
    }
    
    
    public  void searchByAuthor() {
    //As a user , I should be able to search a book by author name
    
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
        
    System.out.println("== Please enter author name ==");
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
            System.out.println("== We could not find the Author book ==");
        }else {
            System.out.println( getAuthorName() + " are in our database: ");
            //System.out.println(list); 
            selectAndAddBasket(list);
        }
            
        if(counter==bookDatabase.size()) {
            System.out.println("== Please enter q to quit ==");
            String exit=scan.next();
        if(exit.equalsIgnoreCase("q")) {
            System.out.println("== Thank you have a nice day ==");
                     
            }
        }
        }
    
    public void searchByGenres() {
    //As a user , I should be able to search a book by genre.                    â€‹
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
    System.out.println("== Please enter genre: ==");
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
        System.out.println("== We could not find this genre in our database. ==");
    }else {
        System.out.println(getGenres()+" books in our database : ");
        //System.out.println(list);
        selectAndAddBasket(list);
    }
                        
    if(counter==bookDatabase.size()) {
        System.out.println("== Please enter q to exist ==");
        String exit=scan.next();
    if(exit.equalsIgnoreCase("q")) {
        System.out.println("Thank you have a nice day");
                                 
    }
    }
    }
    
    //Ahmad => option to search,add and see the basket or return
    public void selectOption() {
        
        System.out.println("======= Please select an option ==========");
        System.out.println();
        System.out.println("1.Check you basket");
        System.out.println("2.Return a book");
        System.out.println("3.Search a book");
        System.out.println("4.Log out");
        
        try {
            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();
            
            switch(option) {
            case 1: 
                //basket(key, value);
                System.out.println("=== Your basket ===");
                System.out.println(basket);
                selectOption();
                break;
            case 2:
                returnBook();
                break;
            case 3:
                chooseAnOption();
                break;  
            case 4:
                logOut();
                System.out.println();
            default:
                System.out.println("== Wrong input, please select 1 to 4 ! ==");
                selectOption();
            }
            scan.close();
        }catch(Exception e) {
            System.out.println("== Wrong input, please try again ! ==");
            selectOption();         
        }
    }
    
    private void logOut() {
        System.out.println("== Thanks for being member of our library. ==");
        System.out.println("== Books have to be returned in 15 days! ==");
        
    }
    
    private void returnBook() {
        // TODO Auto-generated method stub  
    }
    
    public static List<String> basket=new ArrayList<>();
    
    public  void  selectAndAddBasket(List<String> hp){
        //List<String> basket=new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        if(hp.size()>0);
        
        System.out.println("== Please enter the book number to add it to your basket ==");
    
        for(int o=0; o<hp.size(); o++) {
            System.out.println((o+1)+"-"+hp.get(o));
        }
        int select=scan.nextInt();
        if(basket.contains(hp.get(select-1))) {
            System.out.println("== You have already same book in your basket ==");
        }else {
            basket.add(hp.get(select-1));
            System.out.println(hp.get(select-1)+" is added to your basket");
        }
        
        
        System.out.println("== Do you want to add more book from recent reaserch?(yes/no) ==");
        
        String again=scan.next();
        
        if(again.equalsIgnoreCase("yes") && basket.size()< 5) {           
            selectAndAddBasket(hp);
        }else if(again.equalsIgnoreCase("no")) {
        	System.out.println("The books in your basket: " + basket);
        }
        if(basket.size() > 5) {
        	System.out.println("You cannot get more than 5 books! Thank you for your visit!");
            selectOption();
        }
       
    }
}