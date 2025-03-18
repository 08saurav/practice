package InventoryManagementSystem.services;

import InventoryManagementSystem.models.InventoryItem;
import InventoryManagementSystem.repositories.InventoryRepository;

import java.util.Collection;
import java.util.List;

public class InventoryService {
    private InventoryRepository inventoryRepository;
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    public void addItemInInventory(InventoryItem inventoryItem) {
        inventoryRepository.addItem(inventoryItem);
    }
    public void removeItemFromInventory(String inventoryItemId) {
        inventoryRepository.removeItem(inventoryItemId);
    }
    public InventoryItem getItemFromInventory(String inventoryItemId) {
        return inventoryRepository.getItem(inventoryItemId);
    }
    public Collection<InventoryItem> getAllItems() {
        return inventoryRepository.getAllItems();
    }
    public void updateItemInInventory(String inventoryItemId,int newQuantity) {
        InventoryItem item = inventoryRepository.getItem(inventoryItemId);
        if (item != null) {
            item.setQuantity(newQuantity);
        }
    }
}
