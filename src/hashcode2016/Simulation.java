package hashcode2016;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private Map map;

    private List<Order> orders;

    public Simulation(DataContainer dataContainer) {
        this.map = new Map(dataContainer.rows, dataContainer.columns);
        for (Warehouse warehouse : dataContainer.warehouses.values()) {
            map.setCell(warehouse.getX(), warehouse.getY(), warehouse);
        }
        orders = new ArrayList<>();
        for (Order order : dataContainer.orders.values()) {
            orders.add(order);
            map.setCell(order.getClient().getX(), order.getClient().getY(), order.getClient());
        }
    }

    public Map getMap(){
        return map;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
