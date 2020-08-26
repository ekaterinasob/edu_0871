/*
Создать абстрактный класс Animal с характеристиками животного.
Создать класс Horse который наследуется от Animal, в классе Horse реализовать метод public void run(){ System.out.println("Игого, я поскакал(а)"); }
Создать класс Pegasus который наследуется от Horse, в классе Pegasus реализовать метод public void fly(){ System.out.println("Игого, я полетел(а)"); }
Создать объект лошади и вызвать метод run();
Создать объект пегаса и вызвать метод fly();
*/



public class Main{

    public static void main(String[] args) {

        Horse Zina = new Horse("Zina", 10, "black");
        Pegas Alla = new Pegas("Alla", 15, "white");
        Alla.fly();
        Zina.run();


    }

}
class Animal{
    private String nickname;
    private int age;
    private String color;

    public Animal(String nickname, int age, String color) {
        this.nickname = nickname;
        this.age = age;
        this.color = color;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class Horse extends Animal {

    protected String nickname;

    public Horse(String nickname, int age, String color) {
        super(nickname, age, color);
    }

    void run() {
        System.out.println("Игого, я поскакала");

    }
}


    class Pegas extends Horse {
        public Pegas(String nickname, int age, String color) {
            super(nickname, age, color);
        }
        void fly() {
            System.out.println("Игого, я полетела");
        }
    }


