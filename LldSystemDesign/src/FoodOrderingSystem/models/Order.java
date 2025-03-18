package FoodOrderingSystem.models;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    public String orderId;
    String customer;
    Map<String, Integer> items;
    public String restaurant;
    public int totalCost;
    boolean isCompleted;

    public Order(String orderId, String customer, Map<String, Integer> items, String restaurant, int totalCost) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
        this.restaurant = restaurant;
        this.totalCost = totalCost;
        this.isCompleted = false;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}