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
        new Main_testPierre("busy_day.in");
        new Main_testPierre("redundancy.in");
        new Main_testPierre("mother_of_all_warehouses.in");
    }

    public Main_testPierre(String file) {
        System.out.println("Hello World!");
        container = Parser.parse(file);
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

        Commands commands = new Commands();

        System.out.println("Init: " + x + ", " + y);
        int i = 0, numberDrones = orders.size();
        // foreach drones
        for (Drone drone : drones) {
            // selection d'un client au hasard
            if (i > numberDrones) {
                break;
            }
            Order order = orders.get(i);

            /**
             * CHARGEMENT
             */
        boolean canDeliver = true;
            java.util.Map<Product, Integer> needs = order.getOrder();
            for (java.util.Map.Entry<Product, Integer> need :
                    needs.entrySet()) {
                Product p = need.getKey();
                int nbNeed = need.getValue();

                // on retire ça de l'entrepot
                int l = warehouseDrones.unload(p, nbNeed);
                if(l==0){
                    canDeliver=false;
                    break;
                }
                System.out.println();
                drone.load(p, l);
                commands.droneLoad(drone, warehouseDrones, p, nbNeed);
                System.out.println("On envoit le drone " + drone.getId() + " vers order " + order.getId());
            }

            if(!canDeliver){
                continue;
            }

            /**
             * LIVRAISON
             */
            for (java.util.Map.Entry<Product, Integer> need :
                    needs.entrySet()) {
                Product p = need.getKey();
                int nbNeed = need.getValue();

                commands.deliver(drone, order, p, nbNeed);
            }


            i++;
        }


        commands.outputFile(file);

    }


}
