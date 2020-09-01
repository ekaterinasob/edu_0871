public class Main {
    public static void main(String[] args) {

        String[] arr = {"Мама", "Мыла", "Раму"};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (i==j)
                        continue;
                    if (j==k)
                        continue;
                    if (i==k)
                        continue;
                    
                    System.out.println(arr[i] + arr[j] + arr[k]);


                }

            }
        }
    }
}
