// package Object-Oriented-Programming;

// Class Human
class Human {
    // Fields (Instance variables)
    String name;
    int age;

    // Constructor
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Base Class
public class example {

    public static void main(String[] args) {
        // Create an object of class Human
        Human human1 = new Human("Aryajeet", 23);

        System.out.println(human1.name);
        System.out.println(human1.age);
    }
}
