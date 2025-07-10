class Animal {
    String name;
    int age;
    
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }
    
    @Override
    void makeSound() {
        System.out.println(name + " barks: Woof!");
    }
}

class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }
    
    @Override
    void makeSound() {
        System.out.println(name + " meows: Meow!");
    }
}

class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }
    
    @Override
    void makeSound() {
        System.out.println(name + " chirps: Tweet!");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal[] animals = {
            new Dog("Tomppy", 3),
            new Cat("billu nadmosh", 2),
            new Bird("bunty chiddi", 1)
        };
        
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}