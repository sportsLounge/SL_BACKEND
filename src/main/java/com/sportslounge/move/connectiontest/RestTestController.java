package com.sportslounge.move.connectiontest;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/connection")
public class RestTestController {
  	@Value("${spring.profiles.active}")
	String activeProfile;

	ConnectionTestService connectionTestService;

   	RestTestController (ConnectionTestService connectionTestService) {
	 this.connectionTestService = connectionTestService;
   	}

	@Operation(summary = "TEST_GET" , description = "GET Request 연결 테스트용", responses = {
		@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
	})
  	@GetMapping("/test")
  	public ResponseEntity<List<ConnectionTestEntity>> tMethod() {
		log.info("================== APPLICATION_ACTIVE_PROFILE : {} ==================", activeProfile);
		return ResponseEntity.ok().body(connectionTestService.findTest());
	}

	@Operation(summary = "TEST_POST" , description = "POST Request 연결 테스트용", responses = {
		@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
	})
	@PostMapping("/test")
  	public ResponseEntity<ConnectionTestEntity> insert (@Valid @RequestBody ConnectionTestEntity entity) {
		return ResponseEntity.ok().body(connectionTestService.insertTest(entity));
	}

	@Operation(summary = "TEST DELETE", description = "DELETE Request 연결 테스트용", responses = {
		@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
	})
	@DeleteMapping("/test")
	public ResponseEntity<Integer> delete (@Parameter(name = "name", required = true) @RequestParam("name") String name) {
		connectionTestService.deleteTest(name);
		return ResponseEntity.ok(200);
	}
}
