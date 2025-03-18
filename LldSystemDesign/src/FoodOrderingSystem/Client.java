package FoodOrderingSystem;

import FoodOrderingSystem.controllers.FoodOrderingController;
import FoodOrderingSystem.models.MenuItem;
import FoodOrderingSystem.models.Order;
import FoodOrderingSystem.models.Restaurant;
import FoodOrderingSystem.repositories.OrderRepository;
import FoodOrderingSystem.repositories.RestaurantRepository;
import FoodOrderingSystem.services.OrderService;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
//        RestaurantRepository restaurantRepository = new RestaurantRepository();
//        OrderService orderService = new OrderService(restaurantRepository);
//        FoodOrderingController controller = new FoodOrderingController(orderService);
//
//        Map<String, MenuItem> menu1 = new HashMap<>();
//        menu1.put("king_burger", new MenuItem("king_burger", 10));
//        menu1.put("samosa_pizza", new MenuItem("samosa_pizza", 20));
//        menu1.put("alu_pasta", new MenuItem("alu_pasta", 19));
//
//        Map<String, MenuItem> menu2 = new HashMap<>();
//        menu2.put("bendi_macaroni", new MenuItem("bendi_macaroni", 12));
//        menu2.put("samosa_pizza", new MenuItem("samosa_pizza", 25));
//        menu2.put("alu_pasta", new MenuItem("alu_pasta", 17));
//
//        restaurantRepository.addRestaurant(new Restaurant("resta1", menu1, 15));
//        restaurantRepository.addRestaurant(new Restaurant("resta2", menu2, 12));
//
//        // Updating menu
//        restaurantRepository.getRestaurant("resta1").updateMenu("bendi_macaroni", 8);
//        restaurantRepository.getRestaurant("resta1").updateMenu("king_burger", 15);
//
//        controller.placeOrder("cust1", Map.of("bendi_macaroni", 3, "samosa_pizza", 2));
//        controller.placeOrder("cust2", Map.of("alu_pasta", 3));
//
//        // Print all restaurant details
//        controller.printAllRestaurants(restaurantRepository);
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        OrderRepository orderRepository = new OrderRepository();
        OrderService orderService = new OrderService(restaurantRepository, orderRepository);
        FoodOrderingController controller = new FoodOrderingController(orderService);

        for (int i = 1; i <= 5; i++) {
            Map<String, MenuItem> menu = new HashMap<>();
            for (int j = 1; j <= 10; j++) {
                menu.put("item" + j, new MenuItem("item" + j, 10 + j));
            }
            restaurantRepository.addRestaurant(new Restaurant("resta" + i, menu, 4));
        }

        controller.placeOrder("cust1", Map.of("item1", 2, "item3", 1), "lowest_price");
        controller.placeOrder("cust2", Map.of("item2", 3), "max_capacity");
        controller.printAllRestaurants(restaurantRepository);
    }
}
