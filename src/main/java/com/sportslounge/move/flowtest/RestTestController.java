package com.sportslounge.move.flowtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestTestController {
	@GetMapping("/test")
  	public String tMethod() throws Exception {
	  return "test success";
	}
}
