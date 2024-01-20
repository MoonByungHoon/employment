package study.employment.swap;

import study.employment.entity.Member;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ChangeType {
  public Member toEntity(Class<? extends Member> convertClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    Constructor<? extends Member> constructor = convertClass.getDeclaredConstructor();
    return constructor.newInstance();
  }
}
