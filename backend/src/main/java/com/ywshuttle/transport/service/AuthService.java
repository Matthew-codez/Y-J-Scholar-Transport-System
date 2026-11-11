package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.UserAccount;

public interface AuthService {
    UserAccount register(RegisterRequest request);
    String login(LoginRequest request);
}
