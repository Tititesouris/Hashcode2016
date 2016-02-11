package hashcode2016;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Pierre on 11/02/2016.
 */
public class Commands {

    protected int nbCommands = 0;
    protected StringBuilder sb = new StringBuilder();

    protected ArrayList<String> commands = new ArrayList<>();


    /**
     * LOADS NB product in
     *
     * @param drone
     * @param warehouse
     * @param product
     * @param amount
     * @return Returns number of products loaded
     */
    protected int droneLoad(Drone drone, Warehouse warehouse, Product product, int amount) {
        String s="";
        s+=drone.getId() + " L " + warehouse.getId() + " " + product.getType() + " " + amount;
        commands.add(s);
        return -1;
    }

    /**
     * ADVANCED COMMAND, NOT USEFUL FOR NOW
     * @param drone
     * @param warehouse
     * @param product
     * @param amount
     * @return
     */
    protected int droneUnload(Drone drone, Warehouse warehouse, Product product, int amount) {
        return -1;
    }

    /**
     * ADVANCED COMMAND, NOT USEFUL FOR NOW
     * @param drone
     * @return
     */
    protected boolean droneWait(Drone drone) {
        return false;
    }

    /**
     *
     * @param drone
     * @param order
     * @return
     */
    protected boolean deliver(Drone drone, Order order, Product product, int amount){
        String s="";
        s+=drone.getId() + " D " + order.getId() + " " + product.getType() + " " + amount;

        commands.add(s);
        return false;
    }


    /**
     * Adds a command
     * @param s
     */
    protected void addCommand(String s){
        nbCommands++;

        sb.append(s+"\n");
    }


    /**
     * Output a file from commands
     */
    protected boolean outputFile(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("output.txt", "UTF-8");
            writer.println(nbCommands);
            writer.println(sb.toString());
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

}
