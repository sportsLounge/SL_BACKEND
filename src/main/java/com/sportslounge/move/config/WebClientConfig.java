package com.sportslounge.move.config;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {
  	@Value("${kakao.auth.base-host}")
  	String kakaoBaseHost;
    @Bean
    public WebClient webClientForKakaoAuthRestApiCall (WebClient.Builder builder) {
	  return builder.baseUrl(kakaoBaseHost)
		  .clientConnector(new ReactorClientHttpConnector(
			  HttpClient.create().responseTimeout(Duration.ofSeconds(5))
		  ))
		  .build();
	}
}
