package study.employment.swap;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ChangeClass<T> extends ChangeType {

  public <T, U> U convert(T target, Class<U> convertClass) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
    U getConvertClass = convertClass.getDeclaredConstructor().newInstance();

    Field[] targetFields = target.getClass().getDeclaredFields();
    Field[] convertClassFields = getConvertClass.getClass().getDeclaredFields();

    int i = 0;

    for (Field field1 : targetFields) {
      field1.setAccessible(true);

      for (Field field2 : convertClassFields) {
        field2.setAccessible(true);

        if (field1.getName().equals(field2.getName()) && field1.getType().equals(field2.getType()) && field1.get(target) != null) {
          convertClassFields[i].set(getConvertClass, field1.get(target));

          break;
        }
      }
      i++;
    }
    return getConvertClass;
  }

//  public T convert2(T target, T convertClass) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
////    U getConvertClass = convertClass.newInstance();
//
//    Field[] targetFields = target.getClass().getDeclaredFields();
//    Field[] convertClassFields = convertClass.getClass().getDeclaredFields();
//
//    int i = 0;
//
//    for (Field field1 : targetFields) {
//      field1.setAccessible(true);
//
//      for (Field field2 : convertClassFields) {
//        field2.setAccessible(true);
//
//        if (field1.getName().equals(field2.getName()) && field1.getType().equals(field2.getType()) && field1.get(target) != null) {
//          convertClassFields[i].set(convertClass, field1.get(target));
//
//          break;
//        }
//      }
//      i++;
//    }
//
//    return convertClass;
//  }
}

