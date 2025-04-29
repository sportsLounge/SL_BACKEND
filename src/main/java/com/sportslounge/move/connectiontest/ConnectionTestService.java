package com.sportslounge.move.connectiontest;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConnectionTestService {
	ConnectionTestRepository connectionTestRepository;

	ConnectionTestService (ConnectionTestRepository connectionTestRepository) {
		this.connectionTestRepository = connectionTestRepository;
	}
	@Transactional
	public List<ConnectionTestEntity> findTest() {
	  return connectionTestRepository.findAll();
	}
	@Transactional
	public ConnectionTestEntity insertTest (ConnectionTestEntity entity) {
	  return connectionTestRepository.save(entity);
	}
	@Transactional
	public void deleteTest (String name) {
		connectionTestRepository.deleteByName(name);
	}
}
