package com.sportslounge.move.flowtest;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/connection")
public class RestTestController {
  	ConnectionTestService connectionTestService;

   	RestTestController (ConnectionTestService connectionTestService) {
	 this.connectionTestService = connectionTestService;
   	}

	@Operation(summary = "TEST_GET" , description = "GET Request 연결 테스트용", responses = {
		@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
	})
  	@GetMapping("/test")
  	public ResponseEntity<List<ConnectionTestEntity>> tMethod() {
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
