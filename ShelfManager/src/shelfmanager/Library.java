
package shelfmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books;
    private Scanner sc;

    public Library() {
        books =new ArrayList<>();
        sc =new Scanner (System.in);
    }
    
    //1.
    public void addBook(){
        System.out.println("Enter Title: ");
        String title= sc.nextLine();
        System.out.println("Enter Author: ");
        String author = sc.nextLine();
        int isbn = 0;
        while(true)
        {
         System.out.print("Enter ISBN (number): ");
         String input = sc.nextLine();
         try {
             isbn = Integer.parseInt(input); 
        break; 
    } catch (NumberFormatException e) {
        System.out.println("Please enter a number without letter."); 
    }

         }
        
         int quantity = 0;
while (true) {
    System.out.print("Enter Quantity: ");
    String input = sc.nextLine();
    try {
        quantity = Integer.parseInt(input);
        break;
    } catch (NumberFormatException e) {
        System.out.println("Please enter a valid number.");
    }
}
        
        boolean found =false;
        for(Book b:books){
            if(b.getIsbn()==isbn){
               b.setQuantity(b.getQuantity()+ quantity);
                System.out.println("Book exists and we will update the Quantity !");
            found = true;
            break;
            }
        }
        if(found==false)
        {
            books.add(new Book(title,author,isbn,quantity));
            System.out.println("Book added successfully! ");
        }
    }
    
    //2. borrow
    public void lendBook(){
        System.out.println("Enter ISBN To Lend: ");
        int isbn =Integer.parseInt(sc.nextLine());
       boolean found =false;
       for(Book b:books){
           if (b.getIsbn()==isbn)
           {
               found=true;
               if(b.getQuantity()>0){
                   b.setQuantity(b.getQuantity()-1);
                   System.out.println("Book Lent Successfully");
               }
               else{
                   System.out.println("Book not available");
               }
                   break;
           }
       }
       if(!found)
       {
           System.out.println("Book not found");
       }
    }
    
    //3. 
    public void returnBook(){
        System.out.println("Enter ISBN for Book You want to return \n");
        int isbn =Integer.parseInt(sc.nextLine());
        boolean found=false;
        for(Book b:books){
            if(b.getIsbn()==isbn)
            {
                found=true;
                b.setQuantity(b.getQuantity()+1);
                System.out.println("Returned Successfully !");
                break;
            }
        }
        if(!found)
        {
            System.out.println("Book Not Found.");
        }
    }
    //4. 
    public void searchBook(){
        System.out.println("Enter Title or Author or ISBN \n");
        String input=sc.nextLine();
        boolean found=false;
        for(Book b:books){
            if (b.getTitle().equalsIgnoreCase(input)||b.getAuthor().equalsIgnoreCase(input)||String.valueOf(b.getIsbn()).equals(input))
            {
                System.out.println(b);
                found=true;
            }
        }
        if (!found)
        {
            System.out.println("No Matching Book Found");
        }
    }
    
   public void displayBook(){
       if(books.isEmpty()){
           System.out.println("Library is Empty.");
       }
       else{
           System.out.println(" ----- All Books -----");
           for (Book b:books)
           {
               System.out.println(b);
           }
       }
   } 

    
    
    
}
