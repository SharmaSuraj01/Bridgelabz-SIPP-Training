import java.util.*;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public String getItemDetails() {
        return itemName + " - Price: " + price + ", Quantity: " + quantity;
    }
    
    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - applyDiscount();
    }
    
    @Override
    public double applyDiscount() {
        return (getPrice() * getQuantity()) * 0.1; // 10% discount on veg items
    }
    
    @Override
    public String getDiscountDetails() {
        return "Veg Special - 10% discount";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double additionalCharge = 20; 
    
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        double total = (getPrice() + additionalCharge) * getQuantity();
        return total - applyDiscount();
    }
    
    @Override
    public double applyDiscount() {
        return ((getPrice() + additionalCharge) * getQuantity()) * 0.05; 
    }
    
    @Override
    public String getDiscountDetails() {
        return "Non-Veg - 5% discount (includes additional charge)";
    }
}

public class OnlineFoodDeliverySystem {
    public static void processOrder(List<FoodItem> orderItems) {
        double totalBill = 0;
        System.out.println("Order Details:");
        
        for (FoodItem item : orderItems) {
            double itemTotal = item.calculateTotalPrice();
            totalBill += itemTotal;
            
            System.out.println(item.getItemDetails() + ", Total: " + itemTotal);
            if (item instanceof Discountable) {
                System.out.println("  " + ((Discountable) item).getDiscountDetails());
            }
        }
        
        System.out.println("Total Bill: " + totalBill);
    }
    
    public static void main(String[] args) {
        List<FoodItem> order = Arrays.asList(
            new VegItem("Paneer Curry", 200, 2),
            new NonVegItem("sahi paneer", 300, 1),
            new VegItem("Dal Tadka", 150, 1)
        );
        
        processOrder(order);
    }
}