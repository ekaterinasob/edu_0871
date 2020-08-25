public class Cat {

    private String name = "безымянный кот";


    public Cat() {
        this.name = name;
    }

    public void setName(String name) {

    }
    public static void main(String[] args) {

        Cat cat = new Cat();

        cat.setName("Жужик");

        System.out.println(cat.name);
    }
  }


