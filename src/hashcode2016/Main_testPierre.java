package hashcode2016;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main_testPierre {

    static DataContainer container;
    static Map map;
    static List<Drone> drones;
    static List<Delivery> deliveries;
    static List<Order> orders;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        container = Parser.parse("mother_of_all_warehouses.in");
        Simulation sim = new Simulation(container);
        map = sim.getMap();
        System.out.println(container);

        drones = sim.getDrones();
        deliveries = new ArrayList<>();
        orders = sim.getOrders();

        // get first drones
        // order orders by distance from warehouses

        HashMap<Integer, Warehouse> warehouses = container.getWarehouses();
        Warehouse warehouseDrones = warehouses.get(0);
        int x = warehouseDrones.getX(), y = warehouseDrones.getY();

        System.out.println("Init: " + x + ", " + y);
        int i = 0, numberDrones=orders.size();
        // foreach drones
        for (Drone drone : drones) {
            // selection d'un client au hasard
            if(i>numberDrones){
                break;
            }
            Order order = orders.get(i);

            java.util.Map<Product, Integer> needs = order.getOrder();
          /*  for (:
                 ) {
                
            }
            // check have enought
            warehouseDrones.unload()*/

            i++;
        }


    }


}
