import hashcode2016.Cell;
import hashcode2016.Drone;
import hashcode2016.Order;
import hashcode2016.Warehouse;

/**
 * Created by Pierre on 11/02/2016.
 */
public class Tools {

    /**
     * Distance between drone and cell
     * @param drone
     * @param cell
     * @return
     */
    public static double distance(Drone drone, Cell cell){
        return Math.sqrt(Math.pow((drone.getCell().getX()+cell.getX()),2) + Math.pow((drone.getCell().getY()+ cell.getY()),2));
    }

    /**
     * Distance between two cells
     * @param a
     * @param b
     * @return
     */
    public static double distance(Cell a, Cell b){
        return Math.sqrt(Math.pow((a.getX()+b.getX()),2) + Math.pow((a.getY()+ b.getY()),2));
    }

    public static int distanceDroneClient(Drone drone, Warehouse wh, Order order){
        return (int)(distance(drone, wh)+distance(wh, order));
    }

}
