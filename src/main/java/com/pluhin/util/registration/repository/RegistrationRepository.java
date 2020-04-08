package com.pluhin.util.registration.repository;

import com.pluhin.util.registration.model.ConfirmationEntity;
import com.pluhin.util.registration.model.RegistrationEntity;

public interface RegistrationRepository {

  void save(RegistrationEntity entity);

  RegistrationEntity find(String token);

  void savePassword(ConfirmationEntity entity);
}
