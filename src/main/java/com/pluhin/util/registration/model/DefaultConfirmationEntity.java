package com.pluhin.util.registration.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultConfirmationEntity implements ConfirmationEntity {

  private final String token;
  private final String password;

  @JsonCreator
  public DefaultConfirmationEntity(
      @JsonProperty("token") String token,
      @JsonProperty("password") String password
  ) {
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
