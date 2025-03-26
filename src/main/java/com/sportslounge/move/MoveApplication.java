package com.sportslounge.move;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class MoveApplication {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(MoveApplication.class);

		application.addListeners(
			(ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
			  ConfigurableEnvironment env = event.getEnvironment();

			  env.getSystemEnvironment().forEach((key,val)
				  -> Logger.getAnonymousLogger().log(new LogRecord(Level.INFO,"ENV_VAR  >>> KEY:" + key + "VAL:" + val)));
			});

		application.run(args);
		//		SpringApplication.run(MoveApplication.class, args);
	}

}
