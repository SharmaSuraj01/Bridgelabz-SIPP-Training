abstract class Category {
    protected String name;
    
    public Category(String name) {
        this.name = name;
    }
    
    public String getName() { return name; }
}

class BookCategory extends Category {
    public BookCategory() { super("Books"); }
}

class ClothingCategory extends Category {
    public ClothingCategory() { super("Clothing"); }
}

class GadgetCategory extends Category {
    public GadgetCategory() { super("Gadgets"); }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;
    
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public T getCategory() { return category; }
    
    @Override
    public String toString() {
        return name + " (" + category.getName() + ") - $" + String.format("%.2f", price);
    }
}

public class DynamicOnlineMarketplace {
    
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
        System.out.println("Applied " + percentage + "% discount to " + product.getName());
    }
    
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 49.99, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Cotton T-Shirt", 19.99, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 699.99, new GadgetCategory());
        
        System.out.println("Original Prices:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);
        
        System.out.println("\nApplying Discounts:");
        applyDiscount(book, 15);
        applyDiscount(shirt, 25);
        applyDiscount(phone, 10);
        
        System.out.println("\nDiscounted Prices:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);
    }
}