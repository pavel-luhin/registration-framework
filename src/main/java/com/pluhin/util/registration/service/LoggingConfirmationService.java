package com.pluhin.util.registration.service;

import com.pluhin.util.registration.model.ConfirmationEntity;
import com.pluhin.util.registration.model.RegistrationEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingConfirmationService implements ConfirmationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoggingConfirmationService.class);

  private final ConfirmationService delegate;

  public LoggingConfirmationService(ConfirmationService delegate) {
    this.delegate = delegate;
  }

  @Override
  public RegistrationEntity confirm(ConfirmationEntity confirmationEntity) {
    LOGGER.info("Confirming registration with token {}", confirmationEntity.getToken());
    return delegate.confirm(confirmationEntity);
  }
}
