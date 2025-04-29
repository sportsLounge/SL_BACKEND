package com.sportslounge.move.auth.repositoryImpl;

import com.sportslounge.move.auth.AuthEntity;
import com.sportslounge.move.auth.AuthRepositoryCustom;
import com.sportslounge.move.auth.QAuthEntity;

public class AuthRepositoryImpl implements AuthRepositoryCustom {

  @Override
  public AuthEntity findByUserId(String userId) {
    QAuthEntity qAuthEntity = QAuthEntity.authEntity;

    return null;
  }
}
