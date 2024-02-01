package com.services;

import com.enums.Gender;
import com.models.Rating;
import com.models.Restaurant;
import com.models.User;
import com.repository.AppRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodKartImpl implements AppInterface{
  AppRepository repository = AppRepository.getInstance();

  @Override
  public User registerUser(String name, Gender gender, String phoneNum, String pinCode) {
    User user = new User(phoneNum).setName(name).setGender(gender).setPinCode(pinCode);
    repository.registerUser(user);
    return user;
  }

  @Override
  public User logInUser(String phoneNum) {
    User user = repository.getUser(phoneNum);
    repository.logInUser(user);
    return user;
  }

  @Override
  public Restaurant registerRestaurant(String name, String pinCodeList, String dishName,
      double price, int initialQuantity) {
    User user = repository.getLoggedInUser();
    List<String> pinCodes = new ArrayList<>(Arrays.asList(pinCodeList.split("/")));
    Restaurant restaurant = new Restaurant(name).setServiceablePins(pinCodes).setDish(dishName).setPrice(price).setQuantity(initialQuantity).setOwner(user);
    repository.addRestaurant(user, restaurant);
    return restaurant;
  }

  @Override
  public void showRestaurantByPrice(double belowThisPrice) {
    User user = repository.getLoggedInUser();
    List<Restaurant> restaurantList = repository.getRestaurantList();
    for(Restaurant r : restaurantList) {
      if(r.getPrice() <= belowThisPrice && r.getServiceablePins().contains(user.getPinCode()) && r.getQuantity() > 0) {
        System.out.println(r.getName() + " " + r.getDish());
      }
    }
  }

  @Override
  public void showRestaurantByRating(double aboveThisRating) {
    User user = repository.getLoggedInUser();
    List<Restaurant> restaurantList = repository.getRestaurantList();
    for(Restaurant r : restaurantList) {
      if(getAvgRating(r.getRatings()) >= aboveThisRating && r.getServiceablePins().contains(user.getPinCode()) && r.getQuantity() > 0) {
        System.out.println(r.getName() + " " + r.getDish());
      }
    }
  }

  @Override
  public void placeOrder(String restaurantName, int quantity) {
    User user = repository.getLoggedInUser();
    Restaurant restaurant = repository.getRestaurantByName(restaurantName);
    if(restaurant.getQuantity() < quantity) {
      System.out.println("Cannot place order. Quantity not available");
      return;
    }
    if(!restaurant.getServiceablePins().contains(user.getPinCode())) {
      System.out.println("Cannot place order in this pin code");
      return;
    }
    restaurant.subtractQuantity(quantity);
    System.out.println("Order Placed");
  }

  @Override
  public void createReview(String restaurantName, double rating, String comment) {
    Restaurant restaurant = repository.getRestaurantByName(restaurantName);
    Rating ratingObject = new Rating(rating, comment);
    restaurant.addRating(ratingObject);
  }

  @Override
  public void createReview(String restaurantName, double rating) {
    Restaurant restaurant = repository.getRestaurantByName(restaurantName);
    Rating ratingObject = new Rating(rating);
    restaurant.addRating(ratingObject);
  }

  @Override
  public void updateQuantity(String restaurantName, int quantity) {
    Restaurant restaurant = repository.getRestaurantByName(restaurantName);
    restaurant.addQuantity(quantity);
    System.out.println(restaurant);
  }

  @Override
  public void updateLocation(String restaurantName, String pinCodeList) {
    List<String> pinCodes = new ArrayList<>(Arrays.asList(pinCodeList.split("/")));
    Restaurant restaurant = repository.getRestaurantByName(restaurantName);
    restaurant.setServiceablePins(pinCodes);
    System.out.println(restaurant);
  }

  private double getAvgRating(List<Rating> ratings) {
    double sum=0;
    for (Rating r : ratings ) {
      sum+=r.getRate();
    }
    return sum/ratings.size();
  }
}
