package org.example.service.impl;

import org.telegram.telegrambots.meta.api.objects.User;

public interface UserServiceImple {
    User create(User user);

    User getUser(long chatId);
}
