package InventoryManagementSystem.repositories;

import InventoryManagementSystem.models.InventoryItem;

import java.util.*;

public class InventoryRepository {
    private Map<String, InventoryItem> inventory;
    public InventoryRepository() {
        inventory = new HashMap<>();
    }
    public void addItem(InventoryItem inventoryItem) {
        inventory.put(inventoryItem.getInventoryId(), inventoryItem);
    }
    public void removeItem(String inventoryId) {
        inventory.remove(inventoryId);
    }
    public InventoryItem getItem(String inventoryId) {
        return inventory.get(inventoryId);
    }
    public Collection<InventoryItem> getAllItems() {
        return inventory.values();
    }
//    public InventoryItem updateQuantity(String inventoryId, int quantity) {
//        InventoryItem inventoryItem = inventory.get(inventoryId);
//        inventoryItem.setQuantity(quantity);
//
//    }
}
