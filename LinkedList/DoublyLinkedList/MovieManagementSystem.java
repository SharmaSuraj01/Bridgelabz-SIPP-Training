class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;
    
    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    Movie head;
    Movie tail;
    
    void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }
    
    void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }
    
    void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equals(title)) {
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
    
    Movie searchByDirector(String director) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equals(director)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    
    void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }
    
    void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " - " + temp.director + " (" + temp.year + ") Rating: " + temp.rating);
            temp = temp.next;
        }
    }
    
    void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " - " + temp.director + " (" + temp.year + ") Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieList list = new MovieList();
        list.addAtEnd("Ashiqui", "pata nhi", 2010, 8.8);
        list.addAtEnd("Breakup", "Suraj", 1997, 7.8);
        list.addAtBeginning("sayapihjso", "Cameron", 2009, 7.9);
        
        System.out.println("Forward:");
        list.displayForward();
        System.out.println("\nReverse:");
        list.displayReverse();
    }
}