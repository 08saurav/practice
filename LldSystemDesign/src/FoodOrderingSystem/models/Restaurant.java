package FoodOrderingSystem.models;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

// Models
public class Restaurant {
    String name;
    Map<String, MenuItem> menu;
    int maxCapacity;
    int currentCapacity;
    int totalItemsServed;

    public Restaurant(String name, Map<String, MenuItem> menu, int maxCapacity) {
        this.name = name;
        this.menu = new ConcurrentHashMap<>(menu);
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;
        this.totalItemsServed = 0;
    }

    public void updateMenu(String itemName, int newPrice) {
        if (menu.containsKey(itemName)) {
            menu.put(itemName, new MenuItem(itemName, newPrice));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(Map<String, MenuItem> menu) {
        this.menu = menu;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getTotalItemsServed() {
        return totalItemsServed;
    }

    public void setTotalItemsServed(int totalItemsServed) {
        this.totalItemsServed = totalItemsServed;
    }
}