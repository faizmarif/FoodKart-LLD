package com.models;

public class Rating {
  private double rate;
  private String comment;

  public Rating(double rate, String comment) {
    this.rate = rate;
    this.comment = comment;
  }

  public Rating(double rate) {
    this.rate = rate;
  }

  public double getRate() {
    return rate;
  }

  public String getComment() {
    return comment;
  }

  public Rating setRate(double rate) {
    this.rate = rate;
    return this;
  }

  public Rating setComment(String comment) {
    this.comment = comment;
    return this;
  }
}
