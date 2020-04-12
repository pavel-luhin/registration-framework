package com.pluhin.util.registration.service;

import com.pluhin.util.registration.model.RegisteredUser;
import com.pluhin.util.registration.model.RegistrationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingRegistrationService implements RegistrationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoggingRegistrationService.class);

  private final RegistrationService delegate;

  public LoggingRegistrationService(RegistrationService delegate) {
    this.delegate = delegate;
  }

  @Override
  public RegisteredUser register(RegistrationRequest request) {
    LOGGER.info("Registering user with username {}, fullname {} and role {}",
        request.getUsername(),
        request.getFullName(),
        request.getRole().name()
    );
    RegisteredUser user = delegate.register(request);
    LOGGER.info("Registered user with token {}", user.getRegistrationToken());
    return user;
  }
}
