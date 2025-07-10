class Book {
    String title;
    int publicationYear;
    
    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
}

class Author extends Book {
    String name;
    String bio;
    
    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }
    
    void displayInfo() {
        System.out.println("Book: " + title + " (" + publicationYear + ")");
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
    }
}

public class LibraryBook {
    public static void main(String[] args) {
        Author book = new Author("1984", 1949, "balmiki", "A dystopian novel about totalitarianism and surveillance.");
        book.displayInfo();
    }
}