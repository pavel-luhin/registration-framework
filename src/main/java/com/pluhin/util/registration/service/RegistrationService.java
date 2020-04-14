package com.pluhin.util.registration.service;

import com.pluhin.util.registration.model.RegistrationEntity;
import com.pluhin.util.registration.model.RegistrationRequest;

public interface RegistrationService {

  RegistrationEntity register(RegistrationRequest request);
}
