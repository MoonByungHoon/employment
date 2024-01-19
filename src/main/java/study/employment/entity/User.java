package study.employment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@ToString(of = {"id", "username", "password"})
public class User {

  @Id
  @GeneratedValue
  @Column(name = "user_id")
  private Long id;

  @NotBlank
  @Column(length = 40, nullable = false, unique = true)
  private String username;

  @NotBlank
  @Column(length = 256, nullable = false)
  private String password;

//  @OneToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "user_info_id")
//  private UserInfo userInfo;

  public User(Long id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }
}
