package hashcode2016;

import java.util.Map;

/**
 * Created by Guillaume on 11/02/2016.
 */
public class Client extends Cell {

    Map<Product,Integer> need;

    public Client(int x,int y){
        super(x,y);
    }

    public boolean addNeed(Product p, int i){
            if(need.containsKey(p)){
                need.replace(p,need.get(p)+i);
            }
            else {
                need.put(p, i);
            }

            return true;
    }

    public int load(Product p,int i) {
        if(!need.containsKey(p)){
            return -1;
        }

        else{

            if(i==need.get(p)){
                need.remove(p);
            }else {

                need.replace(p, need.get(p) - i);
            }

            return i;
        }
    }



}
