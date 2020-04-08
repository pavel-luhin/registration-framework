package com.pluhin.util.registration.service;

import com.pluhin.util.notification.NotificationService;
import com.pluhin.util.notification.model.DefaultNotificationRequest;
import com.pluhin.util.notification.model.DefaultRecipient;
import com.pluhin.util.notification.model.NotificationRequest;
import com.pluhin.util.notification.model.Recipient;
import com.pluhin.util.notification.model.RecipientType;
import com.pluhin.util.registration.model.RegisteredUser;
import com.pluhin.util.registration.model.RegistrationRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NotifyRegistrationService implements RegistrationService {

  private static final String TEMPLATE_NAME = "REGISTRATION_SUCCESS";

  private final RegistrationService delegate;
  private final NotificationService notificationService;
  private final RecipientType notificationType;

  public NotifyRegistrationService(RegistrationService delegate,
      NotificationService notificationService, RecipientType notificationType) {
    this.delegate = delegate;
    this.notificationService = notificationService;
    this.notificationType = notificationType;
  }

  @Override
  public RegisteredUser register(RegistrationRequest request) {
    RegisteredUser user = delegate.register(request);

    Recipient recipient = new DefaultRecipient(notificationType, request.getUsername());
    NotificationRequest notificationRequest = new DefaultNotificationRequest(
        recipient,
        TEMPLATE_NAME,
        collectParams(request, user),
        Collections.emptyList()
    );
    notificationService.send(notificationRequest);

    return user;
  }

  private Map<String, String> collectParams(RegistrationRequest request, RegisteredUser user) {
    Map<String, String> params = new HashMap<>();
    params.put("${USERNAME}", request.getUsername());
    params.put("${FULL_NAME}", request.getFullName());
    params.put("${TOKEN}", user.getRegistrationToken());
    return params;
  }
}
