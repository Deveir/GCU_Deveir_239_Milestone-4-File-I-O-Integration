package store;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handles file operations for the store.
 */
public class FileService {

    /**
     * Loads store inventory from a JSON file.
     *
     * @param fileName name of the JSON file
     * @return list of products loaded from the file
     */
    public ArrayList<SalableProduct> loadInventory(String fileName) {
        ArrayList<SalableProduct> products = new ArrayList<SalableProduct>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            ProductData[] productDataList = mapper.readValue(new File(fileName), ProductData[].class);

            for (ProductData data : productDataList) {
                if (data.type.equalsIgnoreCase("Weapon")) {
                    products.add(new Weapon(data.id, data.name, data.price, data.damage));
                } else if (data.type.equalsIgnoreCase("Armor")) {
                    products.add(new Armor(data.id, data.name, data.price, data.defense));
                } else if (data.type.equalsIgnoreCase("HealthPotion")) {
                    products.add(new HealthPotion(data.id, data.name, data.price, data.healing));
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading inventory file.");
            System.out.println("Make sure inventory.json exists in the project folder.");
            System.out.println("Error message: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("A general error happened while loading inventory.");
            System.out.println("Error message: " + e.getMessage());
        }

        return products;
    }
}
