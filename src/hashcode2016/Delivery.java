package hashcode2016;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Created by Guillaume on 11/02/2016.
 */
public class Delivery {

    private Drone drone;
    private List<Order> orders=new ArrayList<>();

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

    public boolean validateOrder(Order toRemove){
        if(orders.contains(toRemove)){
            orders.remove(toRemove);
            return true;
        }
        else{
            return false;
        }
    }

    /*
    *
    * Retourne une map contenant la quantité nécessaire manquante pour chaque produit de la livraison
    *
    */
    public HashMap<Product,Integer> getNeededProducts(){
        HashMap<Product,Integer> res = new HashMap<>();
        for(Order o : orders){
            for(Product p : o.getOrder().keySet()){
                if(res.containsKey(p)){
                    res.replace(p,o.getOrder().get(p)+res.get(p));
                }
                else{
                    res.put(p,o.getOrder().get(p));
                }
            }
        }


        Map<Product,Integer> alreadyGet = drone.getProducts();

        for(Product p : alreadyGet.keySet()) {
            if (res.containsKey(p)) {
                res.replace(p, res.get(p) - alreadyGet.get(p));
            }
            if (res.get(p) == 0) {
                res.remove(p);
            }
        }

        return res;
    }

    public Drone getDrone(){
        return drone;
    }

    public List<Order> getOrders(){
        return orders;
    }

}
