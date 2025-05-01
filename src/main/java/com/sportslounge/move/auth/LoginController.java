package com.sportslounge.move.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth", produces = "application/json")
public class LoginController {

  private final LoginService loginService;

  @Operation(summary = "AUTH_KAKAO_CODE", description = "카카오 인가 코드", responses = {
    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
  })
  @GetMapping("/kakaoLogin")
  public ResponseEntity<Object> kakaoLogin () {
    return ResponseEntity.ok().body(loginService.authTokenKakao());
  }
}
