package InventoryManagementSystem.models;

public class InventoryItem {
    String inventoryId;
    String inventoryName;
    int quantity;
    int price;
    public InventoryItem(String inventoryId, String inventoryName, int quantity, int price) {
        this.inventoryId = inventoryId;
        this.inventoryName = inventoryName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
