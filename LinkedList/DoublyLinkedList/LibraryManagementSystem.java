class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;
    
    Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryList {
    Book head;
    Book tail;
    
    void addBook(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }
    
    void removeBook(int bookId) {
        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) return;
        
        if (temp == head && temp == tail) {
            head = tail = null;
        } else if (temp == head) {
            head = head.next;
            head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }
    
    Book searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    
    Book searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equals(author)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    
    void updateAvailability(int bookId, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                return;
            }
            temp = temp.next;
        }
    }
    
    void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title + 
                             ", Author: " + temp.author + ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }
    
    void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title + 
                             ", Author: " + temp.author + ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }
    
    int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryList library = new LibraryList();
        library.addBook("1984", "George Orwell", "Dystopian", 101, true);
        library.addBook("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, false);
        library.addBook("Pride and Prejudice", "Jane Austen", "Romance", 103, true);
        
        System.out.println("Forward Display:");
        library.displayForward();
        System.out.println("\nReverse Display:");
        library.displayReverse();
        System.out.println("\nTotal Books: " + library.countBooks());
    }
}