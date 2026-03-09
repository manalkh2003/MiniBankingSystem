
package shelfmanager;

import java.util.Scanner;
public class ShelfManager {

    
    public static void main(String[] args) {
       Library library = new Library();
        Scanner sc = new Scanner(System.in); 
        int choice;
        
        do{
          System.out.println("\n--- Mini Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Lend Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. Display All Books");
            System.out.println("0. Exit");
            while (true){
                System.out.print("Enter choice: ");
            
            try{
                choice = Integer.parseInt(sc.nextLine());
                if(choice >=0 && choice<=5)
                {
                    break;
                }
                else 
                {
                    System.out.println("Please choice number from minu");
                }
            }
            catch (NumberFormatException e){
                 System.out.println("Please enter a valid number.");
            }
         }
            
             switch (choice) {
                case 1 : library.addBook();break;
                case 2 : library.lendBook();break;
                case 3 : library.returnBook();break;
                case 4 : library.searchBook();break;
                case 5 : library.displayBook();break;
                case 0 : System.out.println("Exiting...");break;
                default : System.out.println("Invalid choice!");
            }
        }
        while (choice !=0);
   
    }
    
}
