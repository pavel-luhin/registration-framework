package com.pluhin.util.registration.model;

public class DefaultRegistrationEntity implements RegistrationEntity {

  private final String username;
  private final String fullName;
  private final String registrationToken;

  public DefaultRegistrationEntity(String username, String fullName, String registrationToken) {
    this.username = username;
    this.fullName = fullName;
    this.registrationToken = registrationToken;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public String getFullName() {
    return fullName;
  }

  @Override
  public String getRegistrationToken() {
    return registrationToken;
  }
}
