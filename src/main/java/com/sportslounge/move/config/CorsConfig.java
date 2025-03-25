package com.sportslounge.move.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
  @Bean
  public CorsFilter corsFilter () {
	CorsConfiguration corsConfig = new CorsConfiguration();
	corsConfig.addAllowedOrigin("*");
	corsConfig.addAllowedHeader("*");
	corsConfig.addAllowedMethod("*");
	
	/* allow origin "*" 과 공존할 수 없는 옵션 */
	//	corsConfig.setAllowCredentials(true);

	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	source.registerCorsConfiguration("/**", corsConfig);

	return new CorsFilter(source);
  }
}
