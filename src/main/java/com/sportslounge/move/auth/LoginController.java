package com.sportslounge.move.auth;

import com.sportslounge.move.auth.dto.KakaoAuthTokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth", produces = "application/json")
public class LoginController {

  private final LoginService loginService;

  @Operation(summary = "AUTH_KAKAO_TOKEN", description = "카카오 인가 코드로 토큰 발급 요청", responses = {
    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(allOf = KakaoAuthTokenResponse.class)))
  })
  @GetMapping("/kakaoToken")
  public ResponseEntity<Object> kakaoLogin (@Valid @RequestParam String authCode) {
    String result = loginService.kakaoLogin(authCode);
    log.info("============== RESULT : {} ==============", result);
    return ResponseEntity.ok().body(result);
  }
}
