import hashcode2016.Cell;
import hashcode2016.Drone;

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
    public double distance(Drone drone, Cell cell){
        return Math.sqrt(Math.pow((drone.getPosition().getX()+cell.getX()),2) + Math.pow((drone.getPosition().getY()+ cell.getY()),2));
    }

    /**
     * Distance between two cells
     * @param a
     * @param b
     * @return
     */
    public double distance(Cell a, Cell b){
        return Math.sqrt(Math.pow((a.getX()+b.getX()),2) + Math.pow((a.getY()+ b.getY()),2));
    }


}
