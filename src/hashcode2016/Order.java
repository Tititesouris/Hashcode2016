package hashcode2016;

import java.util.HashMap;
import java.util.Map;

public class Order extends Cell {

	private int id;


	private int nbItems;

	private Map<Product, Integer> order;

	public Order(int id, int x, int y) {
		super(x,y);
		this.id = id;
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

    public int getY() {
        return y;
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
