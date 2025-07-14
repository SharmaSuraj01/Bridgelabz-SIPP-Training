import java.util.*;

interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;
    private boolean isAvailable;
    
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    
    public int getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    
    public void setAvailable(boolean available) { this.isAvailable = available; }
    
    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author + 
               ", Available: " + isAvailable;
    }
    
    public abstract int getLoanDuration();
}

class Book extends LibraryItem implements Reservable {
    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    public int getLoanDuration() {
        return 14; // 14 days for books
    }
    
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setAvailable(false);
            System.out.println("Book reserved for " + borrowerName);
        } else {
            System.out.println("Book not available for reservation");
        }
    }
    public boolean checkAvailability() {
        return isAvailable();
    }
}

class Magazine extends LibraryItem implements Reservable {
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }
    public int getLoanDuration() {
        return 7;
    }
    
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setAvailable(false);
            System.out.println("Magazine reserved for " + borrowerName);
        } else {
            System.out.println("Magazine not available for reservation");
        }
    }
    public boolean checkAvailability() {
        return isAvailable();
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    
    public int getLoanDuration() {
        return 3; // 3 days for DVDs
    }
    

    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setAvailable(false);
            System.out.println("DVD reserved for " + borrowerName);
        } else {
            System.out.println("DVD not available for reservation");
        }
    }
    
    public boolean checkAvailability() {
        return isAvailable();
    }
}

public class LibraryManagementSystem {
    public static void manageItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails() + ", Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem("John Doe");
            }
        }
    }
    
    public static void main(String[] args) {
        List<LibraryItem> items = Arrays.asList(
            new Book(1, "Java Programming", "Oracle"),
            new Magazine(2, "Tech Today", "Editor"),
            new DVD(3, "Learning Java", "Instructor")
        );
        
        manageItems(items);
    }
}