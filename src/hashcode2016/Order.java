package hashcode2016;

import java.util.HashMap;
import java.util.Map;

public class Order {
	int id;
	Map<Product, Integer> order;

	public Order(int id) {
		this.id = id;
		this.order = new HashMap<Product, Integer>();
	}

	void addProduct(Product p, int quantity) {

		if (order.containsKey(p))
			order.replace(p, order.get(p) + quantity);
		else 
			order.put(p,quantity);

	}
}
