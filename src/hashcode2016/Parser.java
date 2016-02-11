package hashcode2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {

    public static void parse() {
        Scanner scanner;
        try {
            scanner = new Scanner(new File("busy_day.in"));
            String line;

            // first line
            line = scanner.nextLine();


            while (scanner.hasNextLine()) {

                System.out.println(scanner.nextLine());


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
