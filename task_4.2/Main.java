public class Main {

    public static void main(String[] args) {

        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Dog spike = new Dog ("Spike", 20, 5, "gray");
        Cat tom = new Cat ("Tom", 17, 9,"black");
        

    }

}

class Dog{
    String name;
    int height;
    int tail;
    String color;

    public Dog(String name, int height, int tail, String color) {
        this.name = name;
        this.height = height;
        this.tail = tail;
        this.color = color;
    }

}

class Cat{
    String name;
    int height;
    int tail;
    String color;

    public Cat(String name, int height, int tail, String color) {
        this.name = name;
        this.height = height;
        this.tail = tail;
        this.color = color;
    }
}

class Mouse {
    String name;
    int height;
    int tail;

    public Mouse(String name, int height, int tail) {
        this.name = name;
        this.height = height;
        this.tail = tail;

    }

}












