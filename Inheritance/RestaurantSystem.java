class Person {
    String name;
    int id;
    
    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

interface Worker {
    void performDuties();
}

class Chef extends Person implements Worker {
    Chef(String name, int id) {
        super(name, id);
    }
    
    @Override
    public void performDuties() {
        System.out.println("Chef " + name + " is preparing delicious meals");
    }
}

class Waiter extends Person implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }
    
    @Override
    public void performDuties() {
        System.out.println("Waiter " + name + " is serving customers");
    }
}

public class RestaurantSystem {
    public static void main(String[] args) {
        Worker[] workers = {
            new Chef("Priyanshu", 101),
            new Waiter("Aditya", 102)
        };
        
        for (Worker worker : workers) {
            worker.performDuties();
        }
    }
}