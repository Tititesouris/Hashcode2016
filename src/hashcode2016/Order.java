package hashcode2016;

import java.util.HashMap;
import java.util.Map;

public class Order {
	int id;
	private int x;
	private int y;
	private int nbItems;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getNbItems() {
		return nbItems;
	}

	public void setNbItems(int nbItems) {
		this.nbItems = nbItems;
	}

	public Map<Product, Integer> getOrder() {
		return order;
	}

	public void setOrder(Map<Product, Integer> order) {
		this.order = order;
	}
}
