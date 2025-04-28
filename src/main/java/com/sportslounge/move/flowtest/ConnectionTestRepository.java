package com.sportslounge.move.flowtest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionTestRepository extends JpaRepository<ConnectionTestEntity,String> {
    void deleteByName(String name);
}
