package FoodOrderingSystem.repositories;

import FoodOrderingSystem.models.Order;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
public class OrderRepository {
    private static final Map<String, Order> orders = new ConcurrentHashMap<>();

    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }

    public Collection<Order> getAllOrders() {
        return orders.values();
    }
}
