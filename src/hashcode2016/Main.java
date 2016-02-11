package hashcode2016;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static DataContainer container;
    static Map map;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        container = Parser.parse("mother_of_all_warehouses.in");
        Simulation sim = new Simulation(container);
        map=sim.getMap();
        System.out.println(container);



    }



}
