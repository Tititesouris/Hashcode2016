package hashcode2016;

import java.util.HashMap;
import java.util.Map;

public class Order {
	int id;
	private int x;
	private int y;
	Map<Product, Integer> order;

	/**
	 *
	 * @param id
	 * @param x
     * @param y
     */
	public Order(int id, int x, int y) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.order = new HashMap<Product, Integer>();
	}

	void addProduct(Product p, int quantity) {

		if (order.containsKey(p))
			order.replace(p, order.get(p) + quantity);
		else 
			order.put(p,quantity);

	}
}
