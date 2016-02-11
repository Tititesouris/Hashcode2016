package hashcode2016;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drone {

    private float maxPayload;

    private Map<Product, Integer> products;

    public Drone(float maxPayload) {
        this.maxPayload = maxPayload;
        this.products = new HashMap<>();
    }

    public float getMaxPayload() {
        return maxPayload;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
    
}
