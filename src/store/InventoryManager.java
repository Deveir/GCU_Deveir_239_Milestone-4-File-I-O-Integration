package store;

import java.util.ArrayList;

/**
 * Manages store inventory.
 */
public class InventoryManager {
    private ArrayList<SalableProduct> inventory;
    private FileService fileService;

    /**
     * Creates an inventory manager.
     */
    public InventoryManager() {
        inventory = new ArrayList<SalableProduct>();
        fileService = new FileService();
    }

    /**
     * Initializes inventory from an external JSON file.
     */
    public void initializeInventory() {
        inventory.clear();
        inventory = fileService.loadInventory("inventory.json");
    }

    /**
     * Adds a product to inventory.
     *
     * @param product product to add
     */
    public void addProduct(SalableProduct product) {
        inventory.add(product);
    }

    /**
     * Removes a product from inventory.
     *
     * @param product product to remove
     */
    public void removeProduct(SalableProduct product) {
        inventory.remove(product);
    }

    /**
     * Returns the full inventory.
     *
     * @return inventory list
     */
    public ArrayList<SalableProduct> getInventory() {
        return inventory;
    }

    /**
     * Finds a product by ID.
     *
     * @param id product ID
     * @return product if found, otherwise null
     */
    public SalableProduct findProduct(String id) {
        for (SalableProduct product : inventory) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }

        return null;
    }
}