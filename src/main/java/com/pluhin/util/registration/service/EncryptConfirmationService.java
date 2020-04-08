package com.pluhin.util.registration.service;

import com.pluhin.util.registration.model.ConfirmationEntity;
import com.pluhin.util.registration.model.DefaultConfirmationEntity;
import com.pluhin.util.registration.model.RegistrationEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncryptConfirmationService implements ConfirmationService {

  private final ConfirmationService delegate;
  private final PasswordEncoder passwordEncoder;

  public EncryptConfirmationService(ConfirmationService delegate,
      PasswordEncoder passwordEncoder) {
    this.delegate = delegate;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public RegistrationEntity confirm(ConfirmationEntity confirmationEntity) {
    String encodedPassword = passwordEncoder.encode(confirmationEntity.getPassword());

    ConfirmationEntity encodedEntity = new DefaultConfirmationEntity(
        confirmationEntity.getToken(),
        encodedPassword
    );
    return delegate.confirm(encodedEntity);
  }
}
