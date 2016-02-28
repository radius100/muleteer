package com.solveast.muleteer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solveast.muleteer.repositories.LogRepository;

@Transactional
@Service
public class LogCronService {

	@Autowired
	LogRepository logRepository;

	// midnight 0 0 0 * *
	// every hour 0 0 * * *
	// every minute 0 * * * * *
	@Scheduled(cron = "0 0 0 * * *")
	public void deleteDailyLoggs() {
		logRepository.deleteAll();
	}
}
