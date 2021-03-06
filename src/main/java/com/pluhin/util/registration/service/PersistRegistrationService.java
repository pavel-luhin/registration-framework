package com.pluhin.util.registration.service;

import com.pluhin.util.registration.model.DefaultRegistrationEntity;
import com.pluhin.util.registration.model.RegistrationEntity;
import com.pluhin.util.registration.model.RegistrationRequest;
import com.pluhin.util.registration.repository.RegistrationRepository;
import java.util.UUID;

public class PersistRegistrationService implements RegistrationService {

  private final RegistrationRepository registrationRepository;

  public PersistRegistrationService(
      RegistrationRepository registrationRepository) {
    this.registrationRepository = registrationRepository;
  }

  @Override
  public RegistrationEntity register(RegistrationRequest request) {
    String token = UUID.randomUUID().toString().replace("-", "");
    RegistrationEntity entity = new DefaultRegistrationEntity(
        request.getUsername(),
        request.getFullName(),
        token,
        request.getRole()
    );
    registrationRepository.save(entity);
    return new DefaultRegistrationEntity(
        request.getUsername(),
        request.getFullName(),
        token,
        request.getRole()
    );
  }
}
