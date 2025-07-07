public class Product {
    static double discount = 10.0; 
    String productName;
    double price;
    int quantity;
    final int productID;
    Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    void displayDetails() {
        System.out.println("Product: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Product ID: " + productID);
        System.out.println("Discount: " + discount + "%");
    }
    public static void main(String[] args) {
        Product prod1 = new Product("Laptop", 50000.0, 2, 1001);
        
        Product.updateDiscount(15.0);
        
        Object obj = prod1;
        if (obj instanceof Product) {
            ((Product) obj).displayDetails();
        }
    }
}