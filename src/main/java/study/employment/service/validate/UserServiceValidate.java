package study.employment.service.validate;

import study.employment.entity.User;

import java.lang.reflect.Field;

public class UserServiceValidate {

  public void nullPointValidate(User user) {
    if (user == null) {
      throw new NullPointerException("데이터가 없습니다.");
    }
  }

  public void IllegalStateValidate(User findUser, User target) {
    Class<?>[] findUserFields = findUser.getClass().getDeclaredClasses();



  }
}
