package com.pluhin.util.registration.model;

public class DefaultRegisteredUser implements RegisteredUser{

  private final String registrationToken;

  public DefaultRegisteredUser(String registrationToken) {
    this.registrationToken = registrationToken;
  }

  @Override
  public String getRegistrationToken() {
    return registrationToken;
  }
}
