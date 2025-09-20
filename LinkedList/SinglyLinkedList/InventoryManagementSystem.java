package LinkedList.SinglyLinkedList;
class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;
    
    Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryList {
    Item head;
    
    void addItem(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }
    
    void removeItem(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    
    void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }
    
    Item searchById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    
    Item searchByName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equals(itemName)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    
    double calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        return total;
    }
    
    void sortByName() {
        if (head == null || head.next == null) return;
        
        boolean swapped;
        do {
            swapped = false;
            Item current = head;
            while (current.next != null) {
                if (current.itemName.compareTo(current.next.itemName) > 0) {
                    // Swap data
                    String tempName = current.itemName;
                    int tempId = current.itemId;
                    int tempQuantity = current.quantity;
                    double tempPrice = current.price;
                    
                    current.itemName = current.next.itemName;
                    current.itemId = current.next.itemId;
                    current.quantity = current.next.quantity;
                    current.price = current.next.price;
                    
                    current.next.itemName = tempName;
                    current.next.itemId = tempId;
                    current.next.quantity = tempQuantity;
                    current.next.price = tempPrice;
                    
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
    
    void display() {
        Item temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.itemId + ", Name: " + temp.itemName + 
                             ", Qty: " + temp.quantity + ", Price: $" + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryList inventory = new InventoryList();
        inventory.addItem("Laptop", 101, 5, 999.99);
        inventory.addItem("Mouse", 102, 20, 25.50);
        inventory.addItem("Keyboard", 103, 15, 75.00);
        
        inventory.display();
        System.out.println("\nTotal Inventory Value: $" + inventory.calculateTotalValue());
        
        inventory.sortByName();
        System.out.println("\nAfter sorting by name:");
        inventory.display();
    }
}