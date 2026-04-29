package store;

/**
 * A health potion product.
 */
public class HealthPotion extends SalableProduct {
    private int healing;

    /**
     * Creates a health potion.
     *
     * @param id product ID
     * @param name potion name
     * @param price potion price
     * @param healing healing amount
     */
    public HealthPotion(String id, String name, double price, int healing) {
        super(id, name, price);
        this.healing = healing;
    }

    /**
     * Gets healing amount.
     *
     * @return healing amount
     */
    public int getHealing() {
        return healing;
    }

    /**
     * Returns potion information.
     *
     * @return potion text
     */
    public String toString() {
        return super.toString() + " - Healing: " + healing;
    }
}