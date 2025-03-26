package com.sportslounge.move.flowtest;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionTestRepository extends JpaRepository<ConnectionTestEntity,String> {
  List<ConnectionTestEntity> findAll ();
}
