package com.repository;

import com.models.Restaurant;
import com.models.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppRepository {
  private Map<String, User> phoneUserMap;
  private Map<User, List<Restaurant>> userRestaurantMap;
  private Map<String, Restaurant> nameRestaurantMap;
  private User loggedInUser;
  private static AppRepository appRepository=null;

  private AppRepository() {
    phoneUserMap = new HashMap<>();
    userRestaurantMap = new HashMap<>();
    nameRestaurantMap = new HashMap<>();
  }

  public static AppRepository getInstance() {
    if(appRepository == null) {
      appRepository = new AppRepository();
    }
    return appRepository;
  }

  public void registerUser(User user) {
    phoneUserMap.put(user.getPhoneNum(), user);
  }

  public void addRestaurant(User user, Restaurant restaurant) {
    if(!userRestaurantMap.containsKey(user)) {
      userRestaurantMap.put(user, new ArrayList<>());
    }
    userRestaurantMap.get(user).add(restaurant);
    nameRestaurantMap.put(restaurant.getName(), restaurant);
  }

  public User getLoggedInUser() {
    return loggedInUser;
  }

  public void logInUser(User user) {
    this.loggedInUser = user;
  }

  public User getUser(String phoneNum) {
    return phoneUserMap.get(phoneNum);
  }

  public List<Restaurant> getRestaurantList() {
    return new ArrayList<>(nameRestaurantMap.values());
  }

  public Restaurant getRestaurantByName(String restaurantName) {
    return nameRestaurantMap.get(restaurantName);
  }
}
