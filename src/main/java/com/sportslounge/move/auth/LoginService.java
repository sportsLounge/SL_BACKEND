package com.sportslounge.move.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
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

  public String kakaoLogin (String authCode) {
    String authToken = getKakaoAuthToken(authCode);

    return authToken;
  }

  private String getKakaoAuthToken (String authCode) {

    BodyInserters.FormInserter<String> param =  BodyInserters.fromFormData("grant_type","authorization_code")
      .with("client_id",kakao_api_key)
      .with("redirect_uri","https://localhost:3000/auth/redirection")
      .with("code",authCode);

    return webClient.post()
        .uri(uriBuilder -> uriBuilder.path("/oauth/token").build())
        .header("Content-Type","application/x-www-form-urlencoded;charset=utf-8")
        .body(param)
        .retrieve()
        .onStatus(HttpStatusCode::is4xxClientError, response ->
           response.bodyToMono(String.class).map(body -> new RuntimeException("400 Error >>>>>>> \n" + body))
        )
        .bodyToMono(String.class)
        .block();
  }
}
