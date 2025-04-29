package com.sportslounge.move;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Sports_Lounge API", version = "v1", description = "API Documentation"))
@SpringBootApplication
public class MoveApplication {
	public static void main(String[] args) {
	  SpringApplication.run(MoveApplication.class, args);
	}

}
