package study.employment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import study.employment.dto.UserTotalDto;
import study.employment.swap.ChangeClass;

import java.lang.reflect.Field;

@Entity
@Getter @Setter
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

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_info_id")
  private UserInfo userInfo;

  public User(Long id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  public User(Long id, String username) {
    this.id = id;
    this.username = username;
  }
}


//@Test
//public void countByTest() throws IllegalAccessException {
//
//  User user = new User(1L, "adsf", "asdfadf");
//  User user2 = new User(2L, "rturhu54");
//
//  Field[] userFields1 = user.getClass().getDeclaredFields();
//  Field[] userFields2 = user2.getClass().getDeclaredFields();
//
//  for (Field field1 : userFields1) {
//    field1.setAccessible(true);
//    int i = 0;
//    for (Field field2 : userFields2) {
//      field2.setAccessible(true);
//      if (field1.getName() == field2.getName()) {
//        userFields1[i].set(user, field2.get(user2));
//
//        break;
//      }
//      i++;
//    }
//  }
//}