package hashcode2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {

    /**
     * Parse data
     */
    public static void parse() {
        Scanner scanner;
        try {
            scanner = new Scanner(new File("busy_day.in"));
            String[] line;

            // DataContainer
            DataContainer container = new DataContainer();


            // 100rows, 100columns, 3drones, 50turns, maxpayload is 500u
            line = getNextLine(scanner);
            globalInformation(container, line);



            while (scanner.hasNextLine()) {

                System.out.println(scanner.nextLine());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Sets first information
     * @param container
     * @param line
     */
    private static void globalInformation(DataContainer container, String[] line) {
        container.setRows(getIntArg(line[0]));
        container.setColumns(getIntArg(line[1]));
        container.setDrones(getIntArg(line[2]));
        container.setMaxTurns(getIntArg(line[3]));
        container.setMaxPayload(getIntArg(line[4]));
    }


    /**
     * Get next line, exploded by space
     *
     * @param scanner
     * @return
     */
    private static String[] getNextLine(Scanner scanner) {
        String line = scanner.nextLine();
        return line.split(" ");
    }


    /**
     * Get integer argument
     *
     * @param arg
     * @return
     */
    private static int getIntArg(String arg) {
        try {
            return Integer.parseInt(arg);
        } catch (Exception e) {
            System.out.println("NotANumber...");
            System.exit(1);
        }

        return -1;
    }
}
