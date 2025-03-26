package com.sportslounge.move.flowtest;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ConnectionTestService {
	ConnectionTestRepository connectionTestRepository;
	ConnectionTestService (ConnectionTestRepository connectionTestRepository) {
		this.connectionTestRepository = connectionTestRepository;
	}

	public List<ConnectionTestEntity> connectionTest () {
	  return connectionTestRepository.findAll();
	}

	public ConnectionTestEntity insertTest (ConnectionTestEntity entity) {
	  return connectionTestRepository.save(entity);
	}
}
