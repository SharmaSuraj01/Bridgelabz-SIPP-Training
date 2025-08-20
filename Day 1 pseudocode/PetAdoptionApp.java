class Pet {
    protected String name;
    protected int age;
    protected String breed;
    
    public Pet(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Breed: " + breed);
    }
}

class Dog extends Pet {
    private String size;
    
    public Dog(String name, int age, String breed, String size) {
        super(name, age, breed);
        this.size = size;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Size: " + size + ", Sound: Woof!");
    }
}

class Cat extends Pet {
    private boolean isIndoor;
    
    public Cat(String name, int age, String breed, boolean isIndoor) {
        super(name, age, breed);
        this.isIndoor = isIndoor;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Indoor: " + isIndoor + ", Sound: Meow!");
    }
}

class Bird extends Pet {
    private boolean canFly;
    
    public Bird(String name, int age, String breed, boolean canFly) {
        super(name, age, breed);
        this.canFly = canFly;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Can Fly: " + canFly + ", Sound: Tweet!");
    }
}

public class PetAdoptionApp {
    public static void main(String[] args) {
        Pet[] pets = {
            new Dog("Buddy", 3, "Golden Retriever", "Large"),
            new Cat("Whiskers", 2, "Persian", true),
            new Bird("Tweety", 1, "Canary", true)
        };
        
        System.out.println("=== Pet Adoption Center ===");
        for (Pet pet : pets) {
            pet.displayInfo();
            System.out.println();
        }
    }
}