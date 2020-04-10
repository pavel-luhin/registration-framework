package com.pluhin.util.registration.service;

import com.pluhin.util.registration.model.RegistrationEntity;
import com.pluhin.util.registration.repository.RegistrationRepository;

public class DefaultValidationConfirmationService implements ValidationConfirmationService {

  private final RegistrationRepository repository;

  public DefaultValidationConfirmationService(RegistrationRepository repository) {
    this.repository = repository;
  }

  @Override
  public Boolean isValid(String token) {
    RegistrationEntity entity = repository.find(token);
    return entity != null;
  }
}
