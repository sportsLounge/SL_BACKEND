package com.sportslounge.move.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class LoginService {
  @Value("${kakao.auth.api-key}")
  private String kakao_api_key;
  private final AuthRepository authRepository;
  private final WebClient webClient;
  LoginService (AuthRepository authRepository, WebClient webClient) {
    this.authRepository = authRepository;
    this.webClient = webClient;
  }

  public AuthEntity setSession (String userId) {
    return authRepository.findByUserId(userId);
  }

  public Object authTokenKakao () {
    return webClient.get()
        .uri(uriBuilder -> uriBuilder
            .path("TBD...")
            .queryParam("client_id", kakao_api_key)
            .build()
        )
        .retrieve()
        .onStatus(status -> true, response -> response.bodyToMono(String.class).map(body -> new RuntimeException("성공케이스!! >> \n"+body)))
        .bodyToMono(String.class)
        .block();
  }
}
