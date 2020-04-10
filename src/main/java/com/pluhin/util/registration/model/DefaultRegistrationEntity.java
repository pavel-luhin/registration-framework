package com.pluhin.util.registration.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultRegistrationEntity implements RegistrationEntity {

  private final String username;
  private final String fullName;
  private final String registrationToken;
  private final Role role;

  @JsonCreator
  public DefaultRegistrationEntity(
      @JsonProperty("username") String username,
      @JsonProperty("fullName") String fullName,
      @JsonProperty("registrationToken") String registrationToken,
      @JsonProperty("role") Role role
  ) {
    this.username = username;
    this.fullName = fullName;
    this.registrationToken = registrationToken;
    this.role = role;
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

  @Override
  public Role getRole() {
    return role;
  }
}
