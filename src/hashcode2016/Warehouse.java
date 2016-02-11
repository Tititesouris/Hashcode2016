package hashcode2016;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Guillaume on 11/02/2016.
 */
public class Warehouse extends Cell {

    private Map<Product,Integer> products;
    private int id;

    public Warehouse(int id, int x,int y){
        super(x,y);
        this.id = id;
        products = new HashMap<>();

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

    /**
     * Tente de décharger un nombre de produits de la warehouse.
     * La méthode retourne le nombre de produits déchargés, qui peut être
     * différent de celui spécifié si la warehouse n'a pas asser de produits.
     *
     * @param product   Le produit à décharger
     * @param amount    La quantité à décharger
     * @return  La quantité de produits déchargés.
     */
    public int unload(Product product, int amount) {
        Integer loadedProduct = products.get(product);
        if (loadedProduct != null) {
            if (amount < loadedProduct) {
                products.replace(product, loadedProduct - amount);
                return amount;
            }
            products.remove(product);
            return loadedProduct;
        }
        return 0;
    }

    public int getId() {
        return id;
    }
}
