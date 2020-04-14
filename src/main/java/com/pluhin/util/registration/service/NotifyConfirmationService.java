package com.pluhin.util.registration.service;

import com.pluhin.util.notification.NotificationService;
import com.pluhin.util.notification.model.DefaultNotificationRequest;
import com.pluhin.util.notification.model.DefaultRecipient;
import com.pluhin.util.notification.model.NotificationRequest;
import com.pluhin.util.notification.model.Recipient;
import com.pluhin.util.notification.model.RecipientType;
import com.pluhin.util.registration.fetcher.RecipientFetcher;
import com.pluhin.util.registration.model.ConfirmationEntity;
import com.pluhin.util.registration.model.RegistrationEntity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NotifyConfirmationService implements ConfirmationService {

  private static final String TEMPLATE_NAME = "REGISTRATION_FINISHED";

  private final ConfirmationService delegate;
  private final NotificationService notificationService;
  private final RecipientType notificationType;
  private final RecipientFetcher fetcher;

  public NotifyConfirmationService(ConfirmationService delegate,
      NotificationService notificationService, RecipientType notificationType,
      RecipientFetcher fetcher) {
    this.delegate = delegate;
    this.notificationService = notificationService;
    this.notificationType = notificationType;
    this.fetcher = fetcher;
  }

  @Override
  public RegistrationEntity confirm(ConfirmationEntity confirmationEntity) {
    RegistrationEntity entity = delegate.confirm(confirmationEntity);

    String address = fetcher.fetch(entity);
    Recipient recipient = new DefaultRecipient(notificationType, address);
    NotificationRequest notificationRequest = new DefaultNotificationRequest(
        recipient,
        TEMPLATE_NAME,
        collectParams(entity),
        Collections.emptyList()
    );
    notificationService.send(notificationRequest);

    return entity;
  }

  private Map<String, String> collectParams(RegistrationEntity entity) {
    Map<String, String> params = new HashMap<>();
    params.put("${USERNAME}", entity.getUsername());
    params.put("${FULL_NAME}", entity.getFullName());
    return params;
  }
}
