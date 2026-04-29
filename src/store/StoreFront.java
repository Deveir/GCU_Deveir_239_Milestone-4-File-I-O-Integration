package store;

/**
 * Main Store Front application.
 */
public class StoreFront {
    private InventoryManager inventoryManager;
    private ShoppingCart shoppingCart;

    /**
     * Creates the Store Front.
     */
    public StoreFront() {
        inventoryManager = new InventoryManager();
        shoppingCart = new ShoppingCart();
    }

    /**
     * Starts the store by loading inventory and starting the cart.
     */
    public void startStore() {
        inventoryManager.initializeInventory();
        shoppingCart.initializeCart();
    }

    /**
     * Buys a product by moving it from inventory to cart.
     *
     * @param id product ID
     */
    public void buyProduct(String id) {
        SalableProduct product = inventoryManager.findProduct(id);

        if (product != null) {
            shoppingCart.addToCart(product);
            inventoryManager.removeProduct(product);
            System.out.println(product.getName() + " added to cart.");
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    /**
     * Cancels a purchase by moving product from cart back to inventory.
     *
     * @param id product ID
     */
    public void cancelProduct(String id) {
        SalableProduct product = shoppingCart.findProduct(id);

        if (product != null) {
            shoppingCart.removeFromCart(product);
            inventoryManager.addProduct(product);
            System.out.println(product.getName() + " removed from cart and returned to inventory.");
        } else {
            System.out.println("Product not found in cart.");
        }
    }

    /**
     * Shows current inventory.
     */
    public void showInventory() {
        System.out.println("Inventory:");

        if (inventoryManager.getInventory().isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (SalableProduct product : inventoryManager.getInventory()) {
                System.out.println(product);
            }
        }

        System.out.println();
    }

    /**
     * Shows current cart.
     */
    public void showCart() {
        System.out.println("Shopping Cart:");

        if (shoppingCart.getCart().isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            for (SalableProduct product : shoppingCart.getCart()) {
                System.out.println(product);
            }
        }

        System.out.println();
    }

    /**
     * Main method to test the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        StoreFront store = new StoreFront();

        store.startStore();

        System.out.println("Store started.");
        store.showInventory();
        store.showCart();

        System.out.println("Buying product W1...");
        store.buyProduct("W1");
        store.showInventory();
        store.showCart();

        System.out.println("Canceling product W1...");
        store.cancelProduct("W1");
        store.showInventory();
        store.showCart();

        System.out.println("Emptying cart...");
        store.shoppingCart.emptyCart();
        store.showCart();
    }
}

