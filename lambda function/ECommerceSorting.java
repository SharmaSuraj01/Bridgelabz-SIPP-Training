import java.util.*;

class Product {
    private String name;
    private double price;
    private double rating;
    private double discount;
    
    public Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }
    public double getDiscount() { return discount; }
    
    @Override
    public String toString() {
        return String.format("%s - Price: $%.2f, Rating: %.1f, Discount: %.0f%%", 
                           name, price, rating, discount);
    }
}

public class ECommerceSorting {
    
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 999.99, 4.5, 10),
            new Product("Phone", 699.99, 4.8, 15),
            new Product("Tablet", 399.99, 4.2, 20),
            new Product("Watch", 299.99, 4.0, 5)
        );
        
        System.out.println("=== E-Commerce Product Sorting ===");
        System.out.println("Original products:");
        products.forEach(System.out::println);
        
        // Sort by price (ascending)
        System.out.println("\nSorted by Price (Low to High):");
        products.stream()
                .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .forEach(System.out::println);
        
        // Sort by rating (descending)
        System.out.println("\nSorted by Rating (High to Low):");
        products.stream()
                .sorted((p1, p2) -> Double.compare(p2.getRating(), p1.getRating()))
                .forEach(System.out::println);
        
        // Sort by discount (descending)
        System.out.println("\nSorted by Discount (High to Low):");
        products.stream()
                .sorted(Comparator.comparingDouble(Product::getDiscount).reversed())
                .forEach(System.out::println);
    }
}