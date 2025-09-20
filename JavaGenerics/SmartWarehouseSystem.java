import java.util.*;

abstract class WarehouseItem {
    protected String name;
    protected double price;
    
    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + name + " ($" + price + ")";
    }
}

class Electronics extends WarehouseItem {
    public Electronics(String name, double price) {
        super(name, price);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name, double price) {
        super(name, price);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name, double price) {
        super(name, price);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    
    public void addItem(T item) {
        items.add(item);
    }
    
    public T getItem(int index) {
        return items.get(index);
    }
    
    public List<T> getAllItems() {
        return new ArrayList<>(items);
    }
    
    public int size() {
        return items.size();
    }
}

public class SmartWarehouseSystem {
    
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
    
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 999.99));
        electronicsStorage.addItem(new Electronics("Phone", 599.99));
        
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Milk", 3.99));
        groceriesStorage.addItem(new Groceries("Bread", 2.49));
        
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 149.99));
        
        System.out.println("Electronics:");
        displayAllItems(electronicsStorage.getAllItems());
        
        System.out.println("\nGroceries:");
        displayAllItems(groceriesStorage.getAllItems());
        
        System.out.println("\nFurniture:");
        displayAllItems(furnitureStorage.getAllItems());
    }
}