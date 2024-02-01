package com;

import com.enums.Gender;
import com.repository.AppRepository;
import com.services.AppInterface;
import com.services.FoodKartImpl;

public class Driver {

  public static void main(String[] args) {
    AppRepository appRepository = AppRepository.getInstance();
    AppInterface appInterface = new FoodKartImpl();

    appInterface.registerUser("Pralove", Gender.MALE, "phoneNumber-1", "HSR");
    appInterface.registerUser("Nitesh", Gender.MALE, "phoneNumber-2", "BTM");
    appInterface.registerUser("Vatsal", Gender.MALE, "phoneNumber-3", "BTM");

    appInterface.logInUser("phoneNumber-1");
    appInterface.registerRestaurant("Food Court-1", "BTM/HSR", "NI Thali", 100, 5);
    appInterface.registerRestaurant("Food Court-2", "BTM", "Burger", 120, 3);

    appInterface.logInUser("phoneNumber-2");
    appInterface.registerRestaurant("Food Court-3", "HSR", "SI Thali", 150, 1);

    appInterface.logInUser("phoneNumber-3");
    appInterface.showRestaurantByPrice(130);

    appInterface.placeOrder("Food Court-1", 2);
    appInterface.placeOrder("Food Court-2", 7);

    appInterface.createReview("Food Court-2", 3, "Good Food");
    appInterface.createReview("Food Court-1", 5, "Nice Food");
    appInterface.showRestaurantByRating(3);

    appInterface.logInUser("phoneNumber-1");
    appInterface.updateQuantity("Food Court-2", 5);

    appInterface.updateLocation("Food Court-2", "BTM/HSR");
  }

}
