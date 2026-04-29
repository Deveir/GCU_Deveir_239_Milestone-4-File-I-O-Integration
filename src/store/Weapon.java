package store;

/**
 * A weapon product.
 */
public class Weapon extends SalableProduct implements Comparable<Weapon> {
    private int damage;

    /**
     * Creates a weapon.
     *
     * @param id product ID
     * @param name weapon name
     * @param price weapon price
     * @param damage weapon damage
     */
    public Weapon(String id, String name, double price, int damage) {
        super(id, name, price);
        this.damage = damage;
    }

    /**
     * Gets weapon damage.
     *
     * @return damage value
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Compares weapons by name while ignoring case.
     *
     * @param other other weapon
     * @return comparison result
     */
    public int compareTo(Weapon other) {
        return this.getName().compareToIgnoreCase(other.getName());
    }

    /**
     * Returns weapon information.
     *
     * @return weapon text
     */
    public String toString() {
        return super.toString() + " - Damage: " + damage;
    }
}