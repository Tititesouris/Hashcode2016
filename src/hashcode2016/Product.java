package hashcode2016;

public class Product {
	int type;
	float weight;
	public Product(int type, float weight){
		this.type= type;
		this.weight = weight;
	}
	
	boolean verifieMaxPayload(Drone d){
		return d.getMaxPayload()>= this.weight;
		
	}

	public float getWeight() {
		return weight;
	}

	public int getType() {
		return type;
	}
}
