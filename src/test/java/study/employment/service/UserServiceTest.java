package study.employment.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import study.employment.dto.UserTotalDto;
import study.employment.entity.User;
import study.employment.swap.ChangeClass;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest <T> {

  @Test
  public void countByTest() throws IllegalAccessException {

    User user = new User(1L, "adsf", "asdfadf");
//    User user2 = new User(2L, "rturhu54");
    UserTotalDto user2 = new UserTotalDto("ADSF", "33", 10, "asdf");

    Field[] userFields1 = user.getClass().getDeclaredFields();
    Field[] userFields2 = user2.getClass().getDeclaredFields();

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
  }

  @Test
  public void changeTest() throws IllegalAccessException {
    UserTotalDto dto = new UserTotalDto();
    dto.setAge(10);
    dto.setUsername("asdf");
    dto.setEmail("111121414");
    dto.setPassword("28r9guerghdfj");

    User user = new User(1L, "aaaa", "bbbb");

    ChangeClass changeClass = new ChangeClass();

    User entity = (User) changeClass.toEntity(dto, user);

    System.out.println("entity = " + entity);
  }

  @Test
  public void aaaaa() throws IllegalAccessException {
    T targetDto;
    T targetEntity;

    UserTotalDto dto1 = new UserTotalDto("asdf", "12314", 10, "4358903");

    User user = new User();

    targetDto = (T) dto1;
    targetEntity = (T) user;

    Field[] dto = targetDto.getClass().getDeclaredFields();
    Field[] entity = targetEntity.getClass().getDeclaredFields();
    int i = 0;

    for (Field field1 : dto) {
      field1.setAccessible(true);

      for (Field field2 : entity) {
        field2.setAccessible(true);

        if(field1.getName().equals(field2.getName()) && field1.getType().equals(field2.getType()) && field1.get(targetDto) != null) {
          entity[i].set(targetEntity, field1.get(targetDto));
        }
      }

      i++;
    }

    System.out.println("ddd : " + targetEntity);
  }

  @Test
  public void toEntityTest() throws IllegalAccessException {
    UserTotalDto dto1 = new UserTotalDto("asdf", "12314", 10, "4358903");

    User user = new User();

    ChangeClass changeClass = new ChangeClass();

    Object chEntity = changeClass.toEntity(dto1, user);

    System.out.println("chEntity = " + chEntity);
  }
}