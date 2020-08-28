import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Укажите имя файла и нажмите Enter ");

        Scanner scan = new Scanner(System.in);
        String filename = scan.nextLine();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        System.out.println(parseLines(reader));

        }

    private static Object parseLines(BufferedReader reader)throws IOException {
        ArrayList<Integer> numslist = new ArrayList<>();
        StringBuilder list  = new StringBuilder();
        String line = "";
        while ((line = reader.readLine()) !=null) {
            if (Integer.parseInt(line)%2==0) numslist.add(Integer.parseInt(line));

        }
        Collections.sort(numslist);
        for (int i =0; i< numslist.size(); i++) {
            list.append(numslist.get(i));
            list.append(System.lineSeparator());
        }
        return list.toString();

    }

}
