package InventoryManagementSystem;

import InventoryManagementSystem.models.InventoryItem;
import InventoryManagementSystem.repositories.InventoryRepository;
import InventoryManagementSystem.services.InventoryService;

public class Client {
    public static void main(String[] args) {
        InventoryRepository repository = new InventoryRepository();
        InventoryService service = new InventoryService(repository);

        // Adding inventory items
        service.addItemInInventory(new InventoryItem("i1", "Laptop", 10, 75000));
        service.addItemInInventory(new InventoryItem("i2", "Mouse", 50, 1500));

        // Listing all items
        System.out.println("Total Inventory Items: " + service.getAllItems().size());

        // Updating item quantity
        service.updateItemInInventory("i1", 8);

        // Removing an item
        service.removeItemFromInventory("i2");

        // Listing all items after removal
        System.out.println("Total Inventory Items after removal: " + service.getAllItems().size());
    }
}
