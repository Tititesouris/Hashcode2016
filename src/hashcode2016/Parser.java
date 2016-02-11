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

            /**
             * gets products
             */
            container.setNbProductsType(getIntArg(scanner.nextLine()));// products number
            line = getNextLine(scanner);
            for (int i = 0; i < container.getNbProductsType(); i++) {
                container.getProducts().put(i, new Product(i, Float.parseFloat(line[i])));
            }

            /**
             * gets warehouses
             */
            container.setNbWarehouses(getIntArg(scanner.nextLine()));// warehouses number
            for (int idWarehouse = 0; idWarehouse < container.getNbWarehouses(); idWarehouse++) {
                line = getNextLine(scanner); // contains location
                container.getWarehouses().put(idWarehouse, new Warehouse(getIntArg(line[1]), getIntArg(line[0])));

                line = getNextLine(scanner); // contains products numbers
                for (int productId = 0; productId < container.getNbProductsType(); productId++) {
                    // get current warehouse
                    container.getWarehouses().get(idWarehouse).addProduct(container.getProducts().get(productId), getIntArg(line[productId]));
                }
            }



            /**
             * gets orders number
             */
            container.setNbOrders(getIntArg(scanner.nextLine()));// orders number
            for (int orderId = 0; orderId < container.getNbOrders(); orderId++) {
                line = getNextLine(scanner); // contains location
                Order order = new Order(orderId, getIntArg(line[1]), getIntArg(line[0]));
                container.getOrders().put(orderId, order);

               // line = getIntArg(getNextLine(scanner)); // contains products numbers
                for (int product = 0; product < container.getNbProductsType(); product++) {
                    // get current warehouse



                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Sets first information
     *
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
