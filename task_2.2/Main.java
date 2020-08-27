public class Main {

    public static int min(int a, int b, int c, int d) {
        if (c<d) return c;
        else return min(a, b);



        }



    public static int min(int a, int b) {
        if (a<b) return a;
        else return b;



    }

    public static void main(String[] args) throws Exception {

        System.out.println(min(-20, -10));

        System.out.println(min(-40, -10, -30, 40));

        System.out.println(min(-20, -40, -30, 40));

        System.out.println(min(-20, -10, -40, 40));

        System.out.println(min(-20, -10, -30, -40));

    }
}
