package com.pluhin.util.registration.service;

import com.pluhin.util.registration.model.ConfirmationEntity;
import com.pluhin.util.registration.model.RegistrationEntity;

public interface ConfirmationService {

  RegistrationEntity confirm(ConfirmationEntity confirmationEntity);
}
