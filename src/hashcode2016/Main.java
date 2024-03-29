package hashcode2016;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static DataContainer container;
    static Map map;
    static List<Drone> drones;
    static List<Delivery> deliveries;
    static List<Order> orders;
    static Simulation sim;
    static Commands commands=new Commands();

    public static void main(String[] args) {
        new Main("busy_day.in");
        new Main("redundancy.in");
        new Main("mother_of_all_warehouses.in");
    }

    public Main(String file){
        System.out.println("Hello World!");
        container = Parser.parse(file);
        sim = new Simulation(container);
        map = sim.getMap();
        System.out.println(container);

        drones = sim.getDrones();
        deliveries = new ArrayList<>();
        orders = sim.getOrders();


        for (int i = 0; i < drones.size(); i++) {
            deliveries.add(giveOrders(drones.get(i)));
        }

        for (Delivery d : deliveries) {
            executeDelivery(d);
        }

        commands.outputFile(file);


    }
    public static Delivery giveOrders(Drone drone){
        Delivery delivery = new Delivery(drone);

        delivery.addOrder(orders.get(0));

        return delivery;
    }

    public static void executeDelivery(Delivery delivery){
        Drone drone = delivery.getDrone();
        java.util.HashMap<Integer,Warehouse> warehouses = container.getWarehouses();
        int cpt=0;
        while(!delivery.getNeededProducts().isEmpty()){
            java.util.Map<Product,Integer> loadedProducts = sim.loadOnDrone(warehouses.get(cpt),drone,delivery.getNeededProducts());
            for(Product p : loadedProducts.keySet()){
                commands.droneLoad(drone,warehouses.get(cpt),p,loadedProducts.get(p));
            }
        }

        while(!delivery.getOrders().isEmpty()){
            Order toDeliver = delivery.getOrders().get(0);

            //DEliver
            drone.setCell(map.getCell(toDeliver.getX(), toDeliver.getY()));

            for(Product p : toDeliver.getOrder().keySet()){
                drone.unload(p,toDeliver.getOrder().get(p));
                commands.deliver(drone,toDeliver,p,toDeliver.getOrder().get(p));
            }
            delivery.validateOrder(toDeliver);
        }
    }

}
