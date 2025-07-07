public class Book {
    static String libraryName = "City Library";
    String title;
    String author;
    final String isbn;
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "James Gosling", "978-0134685991");
        
        Book.displayLibraryName();   
        Object bookk = book1;
        if (bookk instanceof Book) {
            ((Book) bookk).displayDetails();
        }
    }
}