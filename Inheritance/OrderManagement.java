class Order {
    String orderId;
    String orderDate;
    
    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    
    String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {
    String trackingNumber;
    
    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    
    @Override
    String getOrderStatus() {
        return "Order Shipped - Tracking: " + trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;
    
    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    
    @Override
    String getOrderStatus() {
        return "Order Delivered on " + deliveryDate;
    }
}

public class OrderManagement {
    public static void main(String[] args) {
        Order order1 = new Order("ORD001", "2024-01-15");
        ShippedOrder order2 = new ShippedOrder("ORD002", "2024-01-16", "TRK123456");
        DeliveredOrder order3 = new DeliveredOrder("ORD003", "2024-01-17", "TRK789012", "2024-01-20");
        
        System.out.println(order1.getOrderStatus());
        System.out.println(order2.getOrderStatus());
        System.out.println(order3.getOrderStatus());
    }
}