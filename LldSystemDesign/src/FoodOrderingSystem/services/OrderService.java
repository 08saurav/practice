package FoodOrderingSystem.services;

import FoodOrderingSystem.models.Order;
import FoodOrderingSystem.models.Restaurant;
import FoodOrderingSystem.repositories.OrderRepository;
import FoodOrderingSystem.repositories.RestaurantRepository;

import java.util.*;

public class OrderService {
    private final RestaurantRepository restaurantRepository;
    private final OrderRepository orderRepository;
    private int orderCounter = 1;

    public OrderService(RestaurantRepository restaurantRepository, OrderRepository orderRepository) {
        this.restaurantRepository = restaurantRepository;
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(String customer, Map<String, Integer> items, String strategy) {
        Optional<Restaurant> selectedRestaurant;

        if (strategy.equals("lowest_price")) {
            selectedRestaurant = restaurantRepository.getAllRestaurants().stream()
                    .filter(r -> canFulfillOrder(r, items))
                    .min(Comparator.comparingInt(r -> calculateOrderCost(r, items)));
        } else {
            selectedRestaurant = restaurantRepository.getAllRestaurants().stream()
                    .filter(r -> canFulfillOrder(r, items))
                    .max(Comparator.comparingInt(r -> r.getMaxCapacity() - r.getCurrentCapacity()));
        }

        if (selectedRestaurant.isEmpty()) {
            System.out.println("Order cannot be fulfilled by any restaurant.");
            return null;
        }

        Restaurant restaurant = selectedRestaurant.get();
        int totalCost = calculateOrderCost(restaurant, items);
        String orderId = "order" + orderCounter++;
        Order order = new Order(orderId, customer, items, restaurant.getName(), totalCost);
        restaurant.setCurrentCapacity(restaurant.getCurrentCapacity()+items.values().stream().mapToInt(Integer::intValue).sum());
        restaurant.setTotalItemsServed(restaurant.getTotalItemsServed()+items.values().stream().mapToInt(Integer::intValue).sum());
        orderRepository.addOrder(order);
        return order;
    }

    private boolean canFulfillOrder(Restaurant restaurant, Map<String, Integer> items) {
        int requiredCapacity = items.values().stream().mapToInt(Integer::intValue).sum();
        return requiredCapacity + restaurant.getCurrentCapacity() <= restaurant.getMaxCapacity() &&
                items.keySet().stream().allMatch(item -> restaurant.getMenu().containsKey(item));
    }

    private int calculateOrderCost(Restaurant restaurant, Map<String, Integer> items) {
        return items.entrySet().stream().mapToInt(e -> restaurant.getMenu().get(e.getKey()).price * e.getValue()).sum();
    }
}