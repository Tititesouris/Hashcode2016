package hashcode2016;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Simulation {

    private Map map;

    private List<Order> orders;

    private List<Drone> drones;

    public Simulation(DataContainer dataContainer) {
        this.map = new Map(dataContainer.rows, dataContainer.columns);
        for (Warehouse warehouse : dataContainer.getWarehouses().values()) {
            map.setCell(warehouse.getX(), warehouse.getY(), warehouse);
        }
        orders = new ArrayList<>();
        for (Order order : dataContainer.getOrders().values()) {
            orders.add(order);
        }
        drones = new ArrayList<>();
        for (int i = 0; i < dataContainer.getDrones(); i++) {
            drones.add(new Drone(i, dataContainer.getMaxPayload()));
        }
        map.setDrones(drones);
    }

    public Map getMap() {
        return map;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Drone> getDrones() {
        return drones;
    }

    public java.util.Map<Product, Integer> loadOnDrone(Warehouse warehouse, Drone drone, java.util.Map<Product, Integer> products) {
        java.util.Map<Product, Integer> loadedProducts = new HashMap<>();
        for (Product product : products.keySet()) {
            loadedProducts.put(product, drone.load(product, warehouse.unload(product, products.get(product))));
        }
        return loadedProducts;
    }

}
