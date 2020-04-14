package com.pluhin.util.registration.service;

import com.pluhin.util.notification.NotificationService;
import com.pluhin.util.notification.model.DefaultNotificationRequest;
import com.pluhin.util.notification.model.DefaultRecipient;
import com.pluhin.util.notification.model.NotificationRequest;
import com.pluhin.util.notification.model.Recipient;
import com.pluhin.util.notification.model.RecipientType;
import com.pluhin.util.registration.fetcher.RecipientFetcher;
import com.pluhin.util.registration.model.RegistrationEntity;
import com.pluhin.util.registration.model.RegistrationRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NotifyRegistrationService implements RegistrationService {

  private static final String TEMPLATE_NAME = "REGISTRATION_SUCCESS";

  private final RegistrationService delegate;
  private final NotificationService notificationService;
  private final RecipientType notificationType;
  private final RecipientFetcher fetcher;
  private final String hostname;

  public NotifyRegistrationService(RegistrationService delegate,
      NotificationService notificationService, RecipientType notificationType,
      RecipientFetcher fetcher, String hostname) {
    this.delegate = delegate;
    this.notificationService = notificationService;
    this.notificationType = notificationType;
    this.fetcher = fetcher;
    this.hostname = hostname;
  }

  @Override
  public RegistrationEntity register(RegistrationRequest request) {
    RegistrationEntity user = delegate.register(request);

    String address = fetcher.fetch(user);
    Recipient recipient = new DefaultRecipient(notificationType, address);
    NotificationRequest notificationRequest = new DefaultNotificationRequest(
        recipient,
        TEMPLATE_NAME,
        collectParams(request, user),
        Collections.emptyList()
    );
    notificationService.send(notificationRequest);

    return user;
  }

  private Map<String, String> collectParams(RegistrationRequest request, RegistrationEntity user) {
    Map<String, String> params = new HashMap<>();
    params.put("${USERNAME}", request.getUsername());
    params.put("${FULL_NAME}", request.getFullName());
    params.put("${TOKEN}", user.getRegistrationToken());
    params.put("${HOSTNAME}", hostname);
    return params;
  }
}
