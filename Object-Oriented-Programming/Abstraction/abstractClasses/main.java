package Abstraction.abstractClasses;

// An abstract class is a class that cannot be instantiated on its own and should be subclassed.
abstract class Animal{
    // abstract method (method without a body)
    public abstract void sound();

    // concrete method (method with a body)
    public void sleep(){
        System.out.println("Animal is sleeping");
    }
}

// A subclass derived from the abstract class
class Dog extends Animal{
    @Override
    public void sound(){
        System.out.println("Bark");
    }
}


public class main {
    public static void main(String[] args) {
        Dog dog1 = new Dog();

        dog1.sound();
    }
}
