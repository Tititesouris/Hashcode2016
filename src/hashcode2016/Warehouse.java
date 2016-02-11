package hashcode2016;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Guillaume on 11/02/2016.
 */
public class Warehouse {

    private int x;
    private int y;
    private Map<Product,Integer> products;

    public Warehouse(int x,int y){
        products = new HashMap<Product,Integer>();
        this.x=x;
        this.y=y;
    }

    public boolean addProduct(Product p, int i){
        if(products.containsKey(p)){
            products.replace(p,products.get(p)+i);
        }
        else {
            products.put(p, i);
        }

        return true;
    }

    public Map getProducts(){
        return products;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int unload(Product p, int i){
        if(i>products.get(p)){
            int available = products.get(p);
            products.remove(p);
            return available;
        }
        else{
            if(products.get(p)==null){
                return -1;
            }
            else{
                products.replace(p,products.get(p)-i);
                return i;
            }
        }
    }

}