package com.solveast.muleteer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.solveast.muleteer.service.LogCronService;

@Configuration
@EnableScheduling
public class ScheduleConfig {

	@Bean
	public LogCronService bean() {
		return new LogCronService();
	}
}
