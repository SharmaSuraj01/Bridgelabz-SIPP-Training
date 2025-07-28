import java.util.*;

public class ShoppingCart {
    private HashMap<String, Double> productPrices;
    private LinkedHashMap<String, Integer> cartItems;
    
    public ShoppingCart() {
        productPrices = new HashMap<>();
        cartItems = new LinkedHashMap<>();
        initializePrices();
    }
    
    private void initializePrices() {
        productPrices.put("Laptop", 999.99);
        productPrices.put("Phone", 599.99);
        productPrices.put("Headphones", 199.99);
        productPrices.put("Mouse", 29.99);
    }
    
    public void addItem(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
        }
    }
    
    public void displayCart() {
        System.out.println("Cart (Order added): " + cartItems);
    }
    
    public void displaySortedByPrice() {
        TreeMap<Double, String> sortedByPrice = new TreeMap<>();
        for (String item : cartItems.keySet()) {
            sortedByPrice.put(productPrices.get(item), item);
        }
        System.out.println("Items sorted by price: " + sortedByPrice);
    }
    
    public double getTotalCost() {
        return cartItems.entrySet().stream()
                .mapToDouble(entry -> productPrices.get(entry.getKey()) * entry.getValue())
                .sum();
    }
    
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        cart.addItem("Laptop", 1);
        cart.addItem("Mouse", 2);
        cart.addItem("Phone", 1);
        
        cart.displayCart();
        cart.displaySortedByPrice();
        System.out.println("Total: $" + cart.getTotalCost());
    }
}