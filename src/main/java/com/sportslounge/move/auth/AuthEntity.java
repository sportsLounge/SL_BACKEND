package com.sportslounge.move.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "member")
public class AuthEntity {
  @Id@GeneratedValue
  private String id;
  @JsonProperty("userId")
  @Column(name = "user_id")
  private String userId;
  @JsonProperty("userPw")
  private String userPw;
  @JsonProperty("userPhone")
  private String userPhone;
  @JsonProperty("delYn")
  private Character delYn;
}
