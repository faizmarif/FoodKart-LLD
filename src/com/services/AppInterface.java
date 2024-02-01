package com.services;

import com.enums.Gender;
import com.models.Restaurant;
import com.models.User;

public interface AppInterface {
  User registerUser(String name, Gender gender, String phoneNum, String pinCode);
  User logInUser(String phoneNum);
  Restaurant registerRestaurant(String name, String pinCodeList, String dishName, double price, int initialQuantity);
  void showRestaurantByPrice(double belowThisPrice);
  void showRestaurantByRating(double aboveThisRating);
  void placeOrder(String restaurantName, int quantity);
  void createReview(String restaurantName, double rating, String comment);
  void createReview(String restaurantName, double rating);
  void updateQuantity(String restaurantName, int quantity);
  void updateLocation(String restaurantName, String pinCodeList);

}
