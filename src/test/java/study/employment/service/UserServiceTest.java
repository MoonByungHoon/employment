package study.employment.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import study.employment.entity.User;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

  @Test
  public void countByTest() throws IllegalAccessException {

    User user = new User(1L, "adsf", "asdfadf");
    User user2 = new User(2L, "bjfig", "rturhu54");

    Field[] userFields1 = user.getClass().getDeclaredFields();
    Field[] userFields2 = user2.getClass().getDeclaredFields();

    for (Field field : userFields1) {
      field.setAccessible(true);
      System.out.println("field.get(user) = " + field.get(user));
      System.out.println("field.get(user2) = " + field.get(user2));
    }

    for (Field field1 : userFields1) {
      field1.setAccessible(true);
      int i = 0;
      for (Field field2 : userFields2) {
        field2.setAccessible(true);
        if (field1.getName() == field2.getName()) {
          userFields1[i].set(user, field2.get(user2));
          break;
        }
        i++;
      }
    }

    for (Field field : userFields1) {
      System.out.println("field.get(user) = " + field.get(user));
      System.out.println("field.get(user2) = " + field.get(user2));
    }
  }
}