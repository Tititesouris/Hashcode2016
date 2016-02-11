package hashcode2016;

import java.util.HashMap;
import java.util.Map;

public class Drone {

    private float maxPayload;

    private Map<Product, Integer> products;

    public Drone(float maxPayload) {
        this.maxPayload = maxPayload;
        this.products = new HashMap<>();
    }

    /**
     * Essaie de charger un nombre de produits sur le drone.
     * La méthode retourne le nombre de produits chargés, qui peut être
     * différent de celui spécifié si c'est trop lourd pour le drone.
     *
     * @param product   Le produit à charger
     * @param amount    La quantité à charger
     * @return  Nombre de produits chargés.
     */
    public int load(Product product, int amount) {
        if (!products.containsKey(product))
            products.put(product, 0);

        int loaded = 0;
        while (loaded < amount && getPayloadWeight() + product.getWeight() <= maxPayload) {
            loaded++;
            products.replace(product, products.get(product) + 1);
        }
        return loaded;
    }

    /**
     * Tente de décharger un nombre de produits du drone.
     * La méthode retourne le nombre de produits déchargés, qui peut être
     * différent de celui spécifié si le drone n'a pas asser de produits.
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

    public float getPayloadWeight() {
        float payload = 0;
        for (Product product : products.keySet()) {
            payload += product.getWeight() * products.get(product);
        }
        return payload;
    }

    public float getMaxPayload() {
        return maxPayload;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
    
}
