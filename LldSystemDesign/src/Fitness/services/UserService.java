package Fitness.services;

import Fitness.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    public Map<String, User> users = new HashMap<>();

    public void registerUser(String name, String email, String location) {
        users.put(email, new User(name, email, location));
    }
}
