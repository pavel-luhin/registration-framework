package com.pluhin.util.registration.service;

import com.pluhin.util.registration.exception.InvalidRegistrationTokenException;
import com.pluhin.util.registration.model.ConfirmationEntity;
import com.pluhin.util.registration.model.RegistrationEntity;
import com.pluhin.util.registration.repository.RegistrationRepository;

public class DefaultConfirmationService implements ConfirmationService {

  private final RegistrationRepository repository;

  public DefaultConfirmationService(RegistrationRepository repository) {
    this.repository = repository;
  }

  @Override
  public RegistrationEntity confirm(ConfirmationEntity confirmationEntity) {
    String token = confirmationEntity.getToken();
    RegistrationEntity entity = repository.find(token);
    if (entity == null) {
      throw new InvalidRegistrationTokenException("Token " + token + " is invalid");
    }

    repository.savePassword(confirmationEntity);
    return entity;
  }
}
