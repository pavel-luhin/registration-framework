package com.pluhin.util.registration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingValidationConfirmationService implements ValidationConfirmationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoggingValidationConfirmationService.class);

  private final ValidationConfirmationService delegate;

  public LoggingValidationConfirmationService(
      ValidationConfirmationService delegate) {
    this.delegate = delegate;
  }

  @Override
  public Boolean isValid(String token) {
    LOGGER.info("Validating registration token {}", token);
    return delegate.isValid(token);
  }
}
