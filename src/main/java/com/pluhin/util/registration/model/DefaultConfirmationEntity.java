package com.pluhin.util.registration.model;

public class DefaultConfirmationEntity implements ConfirmationEntity {

  private final String token;
  private final String password;

  public DefaultConfirmationEntity(String token, String password) {
    this.token = token;
    this.password = password;
  }

  @Override
  public String getToken() {
    return token;
  }

  @Override
  public String getPassword() {
    return password;
  }
}
