package com.sportslounge.move.connectiontest;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "test")
public class ConnectionTestEntity {
  @Id
  private String name;
}
