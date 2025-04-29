package com.sportslounge.move.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth", produces = "application/json")
public class LoginController {

  LoginService loginService;

  LoginController (LoginService loginService) {
    this.loginService = loginService;
  }

  @Operation(summary = "AUTH_GET", description = "세션 생성용", responses = {
    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
  })
  @GetMapping
  public ResponseEntity<Object> setSession (@Valid @RequestParam String userId) {
    return ResponseEntity.ok().body(loginService.setSession(userId));
  }

  @Operation(summary = "AUTH_POST", description = "계정 가입", responses = {
    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
  })
  @PostMapping
  public ResponseEntity<Object> join () {
    return ResponseEntity.ok().body("succeed");
  }
}
