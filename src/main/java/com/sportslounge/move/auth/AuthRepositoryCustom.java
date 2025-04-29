package com.sportslounge.move.auth;

public interface AuthRepositoryCustom {
  AuthEntity findByUserId (String userId);
}
