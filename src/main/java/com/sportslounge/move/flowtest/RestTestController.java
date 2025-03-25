package com.sportslounge.move.flowtest;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestTestController {
	@GetMapping("/test")
  	public ResponseEntity<Map<String, String>> tMethod() throws Exception {
	  Map<String, String> response = new HashMap<>();
	  response.put("result","test_success");
	  return ResponseEntity.ok(response);
	}
}
