import java.util.*;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;
    
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    
    public abstract double calculateDiscount();
    
    public double getFinalPrice() {
        double tax = (this instanceof Taxable) ? ((Taxable) this).calculateTax() : 0;
        return price + tax - calculateDiscount();
    }
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1; // 10% discount
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }
    
    @Override
    public String getTaxDetails() {
        return "GST 18%";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% GST
    }
    
    @Override
    public String getTaxDetails() {
        return "GST 12%";
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

public class ECommercePlatform {
    public static void calculateFinalPrice(List<Product> products) {
        for (Product product : products) {
            System.out.println(product.getName() + " - Final Price: " + product.getFinalPrice());
        }
    }
    
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Electronics(1, "Laptop", 50000),
            new Clothing(2, "Shirt", 1000),
            new Groceries(3, "Rice", 500)
        );
        
        calculateFinalPrice(products);
    }
}