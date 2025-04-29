package com.sportslounge.move.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<AuthEntity,String>, AuthRepositoryCustom {}
