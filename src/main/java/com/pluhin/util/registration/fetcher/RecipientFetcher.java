package com.pluhin.util.registration.fetcher;

import com.pluhin.util.registration.model.RegistrationEntity;

public interface RecipientFetcher {

  String fetch(RegistrationEntity entity);
}
