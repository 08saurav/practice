package FoodOrderingSystem.controllers;

import FoodOrderingSystem.models.Order;
import FoodOrderingSystem.models.Restaurant;
import FoodOrderingSystem.repositories.RestaurantRepository;
import FoodOrderingSystem.services.OrderService;

import java.util.List;
import java.util.Map;

public class FoodOrderingController {
    private final OrderService orderService;

    public FoodOrderingController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void placeOrder(String customer, Map<String, Integer> items, String strategy) {
        Order order = orderService.placeOrder(customer, items, strategy);
        if (order != null) {
            System.out.println("Order placed: " + order.orderId + " at " + order.restaurant + " for " + order.totalCost + " Rs");
        }
    }
    public void printAllRestaurants(RestaurantRepository restaurantRepository) {
        for (Restaurant restaurant : restaurantRepository.getAllRestaurants()) {
            System.out.println("Name: " + restaurant.getName() + ", Menu: " + restaurant.getMenu() + ", Capacity: " + restaurant.getCurrentCapacity() + "/" + restaurant.getMaxCapacity());
        }
    }
}

