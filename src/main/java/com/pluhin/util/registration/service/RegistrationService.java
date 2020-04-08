package com.pluhin.util.registration.service;

import com.pluhin.util.registration.model.RegisteredUser;
import com.pluhin.util.registration.model.RegistrationRequest;

public interface RegistrationService {

  RegisteredUser register(RegistrationRequest request);
}
