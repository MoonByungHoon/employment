package study.employment.swap;

import java.lang.reflect.Field;

public class ChangeClass<T> {
  private T target;
  private T target2;

  public <T> T toEntity(T targetDto, T targetEntity) throws IllegalAccessException {

    Field[] dto = targetDto.getClass().getDeclaredFields();
    Field[] entity = targetEntity.getClass().getDeclaredFields();

    int i = 0;

    for (Field field1 : dto) {
      field1.setAccessible(true);

      for (Field field2 : entity) {
        field2.setAccessible(true);

        if (field1.getName().equals(field2.getName()) && field1.getType().equals(field2.getType()) && field1.get(targetDto) != null) {
          entity[i].set(targetEntity, field1.get(targetDto));
          
          break;
        }
      }
      i++;
    }

    return targetEntity;
  }
}
