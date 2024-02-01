package com.models;

import java.util.ArrayList;
import java.util.List;

// can serve only one dish
public class Restaurant {
  private User owner;
  private String name;
  private List<String> serviceablePins;
  private String dish;
  private double price;
  private int quantity;
  private List<Rating> ratings;

  public Restaurant(User owner, String name, String dish, double price,
      int quantity) {
    this.owner = owner;
    this.name = name;
    this.serviceablePins = new ArrayList<>();
    this.dish = dish;
    this.price = price;
    this.quantity = quantity;
  }

  public Restaurant(String name) {
    this.name = name;
    serviceablePins = new ArrayList<>();
    ratings = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public List<String> getServiceablePins() {
    return serviceablePins;
  }

  public String getDish() {
    return dish;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public User getOwner() {
    return owner;
  }

  public List<Rating> getRatings() {
    return ratings;
  }

  public Restaurant setName(String name) {
    this.name = name;
    return this;
  }

  public Restaurant setServiceablePins(List<String> serviceablePins) {
    this.serviceablePins = serviceablePins;
    return this;
  }

  public Restaurant setDish(String dish) {
    this.dish = dish;
    return this;
  }

  public Restaurant setPrice(double price) {
    this.price = price;
    return this;
  }

  public Restaurant setQuantity(int quantity) {
    this.quantity = quantity;
    return this;
  }

  public Restaurant addQuantity(int quantity) {
    this.quantity += quantity;
    return this;
  }

  public Restaurant subtractQuantity(int quantity) {
    this.quantity -= quantity;
    return this;
  }

  public Restaurant setOwner(User owner) {
    this.owner = owner;
    return this;
  }

  public Restaurant addRating(Rating rating) {
    this.ratings.add(rating);
    return this;
  }

  @Override
  public String toString() {
    return "Restaurant{" +
        "name='" + name + '\'' +
        ", serviceablePins=" + serviceablePins +
        ", dish='" + dish + '\'' +
        ", price=" + price +
        ", quantity=" + quantity +
        '}';
  }
}
