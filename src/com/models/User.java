package com.models;

import com.enums.Gender;

//started 2:40 PM
//user can order food
//name, gender, phoneNumber(unique) and pincode.
public class User {
  private String name;
  private Gender gender;
  private final String phoneNum;
  private String pinCode;

  public User(String name, Gender gender, String phoneNum, String pinCode) {
    this.name = name;
    this.gender = gender;
    this.phoneNum = phoneNum;
    this.pinCode = pinCode;
  }

  public User(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  public String getName() {
    return name;
  }

  public Gender getGender() {
    return gender;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public String getPinCode() {
    return pinCode;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }

  public User setGender(Gender gender) {
    this.gender = gender;
    return this;
  }

  public User setPinCode(String pinCode) {
    this.pinCode = pinCode;
    return this;
  }
}
