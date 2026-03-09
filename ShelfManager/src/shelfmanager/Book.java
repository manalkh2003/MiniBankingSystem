
package shelfmanager;
import java.util.Objects;

public class Book {
    final private String title;
    final private String author;
    final private int isbn;
    private int quantity;

    public Book(String title, String author, int isbn, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

   

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

    @Override
    public String toString() {
        return "Title: "+title +" , Author: "+author+" , ISBN: "+isbn+ " , Quantity:  "+ quantity; 
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(!(obj instanceof Book))
            return false;
        Book book =(Book)obj;
        return isbn == book.isbn;
    }
    
    
    
}
