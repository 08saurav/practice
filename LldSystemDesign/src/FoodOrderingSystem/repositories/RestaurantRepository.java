package FoodOrderingSystem.repositories;

import FoodOrderingSystem.models.Restaurant;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicInteger;

public class RestaurantRepository {
    private static final Map<String, Restaurant> restaurants = new ConcurrentHashMap<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getName(), restaurant);
    }

    public Restaurant getRestaurant(String name) {
        return restaurants.get(name);
    }

    public Collection<Restaurant> getAllRestaurants() {
        return restaurants.values();
    }
}
