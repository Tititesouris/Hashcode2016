package hashcode2016;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static DataContainer container;
    static Map map;
    static List<Drone> drones;
    static List<Delivery> deliveries;
    static List<Order> orders;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        container = Parser.parse("mother_of_all_warehouses.in");
        Simulation sim = new Simulation(container);
        map=sim.getMap();
        System.out.println(container);

        drones = sim.getDrones();
        deliveries = new ArrayList<>();
        orders=sim.getOrders();



        for(int i=0;i<drones.size();i++){
            deliveries.add(giveOrders(drones.get(i)));
        }



    }

    public static Delivery giveOrders(Drone drone){
        Delivery delivery = new Delivery(drone);

        

        return delivery;
    }

}
