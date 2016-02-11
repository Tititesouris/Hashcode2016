package hashcode2016;

/**
 * Created by Pierre on 11/02/2016.
 */
public class DataContainer {

    protected int rows;
    protected int columns;
    protected int drones;
    protected int maxTurns;
    protected int maxPayload;

    protected int nbProductsType;
    protected int nbWarehouses;
    protected int nbOrders;


    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getDrones() {
        return drones;
    }

    public void setDrones(int drones) {
        this.drones = drones;
    }

    public int getMaxTurns() {
        return maxTurns;
    }

    public void setMaxTurns(int maxTurns) {
        this.maxTurns = maxTurns;
    }

    public int getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(int maxPayload) {
        this.maxPayload = maxPayload;
    }

    public int getNbProductsType() {
        return nbProductsType;
    }

    public void setNbProductsType(int nbProductsType) {
        this.nbProductsType = nbProductsType;
    }

    public int getNbWarehouses() {
        return nbWarehouses;
    }

    public void setNbWarehouses(int nbWarehouses) {
        this.nbWarehouses = nbWarehouses;
    }

    public int getNbOrders() {
        return nbOrders;
    }

    public void setNbOrders(int nbOrders) {
        this.nbOrders = nbOrders;
    }
}
