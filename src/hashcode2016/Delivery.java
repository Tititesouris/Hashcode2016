package hashcode2016;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Guillaume on 11/02/2016.
 */
public class Delivery {

    private Drone drone;
    private List<Order> orders;

    public Delivery(Drone d){
        drone=d;
    }

    public boolean addOrder(Order toAdd){
        if(orders.contains(toAdd)){
            return false;
        }
        else{
            orders.add(toAdd);
            return true;
        }
    }

    public HashMap<Product,Integer> getNeededProducts(){
        HashMap<Product,Integer> res = new HashMap<>();
        for(Order o : orders){
            
        }
        return res;
    }

}
