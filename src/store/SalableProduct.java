package store;

/**
 * A basic product that can be sold in the store.
 */
public class SalableProduct {
    private String id;
    private String name;
    private double price;

    /**
     * Creates a product.
     *
     * @param id product ID
     * @param name product name
     * @param price product price
     */
    public SalableProduct(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * Gets product ID.
     *
     * @return product ID
     */
    public String getId() {
        return id;
    }

    /**
     * Gets product name.
     *
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets product price.
     *
     * @return product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns product information.
     *
     * @return product text
     */
    public String toString() {
        return id + " - " + name + " - $" + price;
    }
}