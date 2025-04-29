package com.sportslounge.move.auth;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
  AuthRepository authRepository;

  LoginService (AuthRepository authRepository) {
    this.authRepository = authRepository;
  }

  public AuthEntity setSession (String userId) {
    return authRepository.findByUserId(userId);
  }
}
