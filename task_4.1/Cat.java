public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat(int age, int weight, int strength) {
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    public boolean fight(Cat anotherCat) {
     
        int raund1 = this.age> anotherCat.age?1:0;
        int raund2 = this.strength>anotherCat.strength?1:0;
        int raund3 = this.weight>anotherCat.weight?1:0;

        int raund  = raund1+raund2+raund3;
        return raund>=2?true:false;


    }

    public static void main(String[] args) {
        Cat Cat1 = new Cat (10, 13, 1);
        Cat Cat2 = new Cat(4, 8, 2);
        System.out.println(Cat1.fight(Cat2));
        System.out.println(Cat2.fight(Cat1));



    }

}

