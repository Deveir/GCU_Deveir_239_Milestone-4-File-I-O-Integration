package store;

/**
 * Simple class used to read product information from JSON.
 */
public class ProductData {
    public String type;
    public String id;
    public String name;
    public double price;
    public int damage;
    public int defense;
    public int healing;

    /**
     * Empty constructor needed for Jackson.
     */
    public ProductData() {
    }
}