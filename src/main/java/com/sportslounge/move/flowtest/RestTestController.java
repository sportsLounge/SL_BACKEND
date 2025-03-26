package com.sportslounge.move.flowtest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestTestController {
  ConnectionTestService connectionTestService;
  RestTestController (ConnectionTestService connectionTestService) {
	this.connectionTestService = connectionTestService;
  }
	@GetMapping("/test")
  	public ResponseEntity<Map<String, Object>> tMethod() {
	  Map<String, Object> response = new HashMap<>();
	  response.put("result",connectionTestService.connectionTest());
	  return ResponseEntity.ok(response);
	}

	@PostMapping("/test")
  	public ResponseEntity<Map<String,String>> insert (@RequestBody ConnectionTestEntity entity) {
		Map<String, String> response = new HashMap<>();

		response.put("result", Objects.nonNull(entity) ? "success" : "fail");

		if(Objects.nonNull(entity)) connectionTestService.insertTest(entity);

		return ResponseEntity.ok(response);
	}
}
