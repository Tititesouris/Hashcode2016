package hashcode2016;

public class Simulation {

    private Map map;

    public Simulation(DataContainer dataContainer) {
        this.map = new Map(dataContainer.rows, dataContainer.columns);
        for (Warehouse warehouse : dataContainer.warehouses.values()) {
            map.setCell(warehouse.getX(), warehouse.getY(), warehouse);
        }
        for (Order order : dataContainer.orders.values()) {
            map.setCell(order.getX(), order.getY(), new Client(order.getX(), order.getY()));
        }
    }

}
