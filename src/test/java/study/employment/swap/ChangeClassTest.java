package study.employment.swap;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChangeClassTest<T> {


//  @Test
//  public void countByTest() throws IllegalAccessException {
//
//    Member user = new Member(1L, "adsf", "asdfadf");
////    Member user2 = new Member(2L, "rturhu54");
//    UserTotalDto user2 = new UserTotalDto("ADSF", "33", 10, "asdf");
//
//    Field[] userFields1 = user.getClass().getDeclaredFields();
//    Field[] userFields2 = user2.getClass().getDeclaredFields();
//
//    for (Field field1 : userFields1) {
//      field1.setAccessible(true);
//      int i = 0;
//      for (Field field2 : userFields2) {
//        field2.setAccessible(true);
//        if (field1.getName() == field2.getName()) {
//          userFields1[i].set(user, field2.get(user2));
//
//          break;
//        }
//        i++;
//      }
//    }
//  }
//
//  @Test
//  public void changeTest() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
//    UserTotalDto dto = new UserTotalDto();
//    dto.setAge(10);
//    dto.setUsername("asdf");
//    dto.setEmail("111121414");
//    dto.setPassword("28r9guerghdfj");
//
//    Member user = new Member(1L, "aaaa", "bbbb");
//
//    ChangeClass changeClass = new ChangeClass();
//
//    Member entity = (Member) changeClass.convert(dto, Member.class);
//
//    System.out.println("entity = " + entity);
//  }
//
//  @Test
//  public void aaaaa() throws IllegalAccessException {
//    T targetDto;
//    T targetEntity;
//
//    UserTotalDto dto1 = new UserTotalDto("asdf", "12314", 10, "4358903");
//
//    Member user = new Member();
//
//    targetDto = (T) dto1;
//    targetEntity = (T) user;
//
//    Field[] dto = targetDto.getClass().getDeclaredFields();
//    Field[] entity = targetEntity.getClass().getDeclaredFields();
//    int i = 0;
//
//    for (Field field1 : dto) {
//      field1.setAccessible(true);
//
//      for (Field field2 : entity) {
//        field2.setAccessible(true);
//
//        if (field1.getName().equals(field2.getName()) && field1.getType().equals(field2.getType()) && field1.get(targetDto) != null) {
//          entity[i].set(targetEntity, field1.get(targetDto));
//        }
//      }
//
//      i++;
//    }
//
//    System.out.println("ddd : " + targetEntity);
//  }
//
//  @Test
//  public void toEntityTest() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
//    UserTotalDto dto1 = new UserTotalDto("asdf", "12314", 10, "4358903");
//
//    Member user = new Member();
//
//    ChangeClass changeClass = new ChangeClass();
//
//    Object convert = changeClass.convert(dto1, Member.class);
////    changeClass.toEntity((Class<? extends Member>) changeClass.convert2(dto1, user));
//
//
////    System.out.println("chEntity = " + entity);
//  }
//
//  @Test
//  // 예시
//  public void mmain(String[] args) {
//    // 예시 Dto
//    MyDto myDto = new MyDto();
//    myDto.setId(1L);
//    myDto.setName("John Doe");
//
//    try {
//      // Dto를 Entity로 변환
//      EntityDtoConverter entityDtoConverter = new EntityDtoConverter();
//      MyEntity myEntity = entityDtoConverter.convertDtoToEntity(myDto, MyEntity.class);
//
//      // 변환된 Entity 확인
//      System.out.println("Entity ID: " + myEntity.getId());
//      System.out.println("Entity Name: " + myEntity.getName());
//    } catch (InstantiationException | IllegalAccessException e) {
//      e.printStackTrace();
//    }
//  }
//
//  public class EntityDtoConverter {
//
//    public static <T, U> U convertDtoToEntity(T dto, Class<U> entityClass) throws IllegalAccessException, InstantiationException {
//      U entity = entityClass.newInstance();
//
//      Field[] dtoFields = dto.getClass().getDeclaredFields();
//      Field[] entityFields = entityClass.getDeclaredFields();
//
//      for (Field dtoField : dtoFields) {
//        dtoField.setAccessible(true);
//        Object dtoValue = dtoField.get(dto);
//
//        for (Field entityField : entityFields) {
//          entityField.setAccessible(true);
//
//          if (dtoField.getName().equals(entityField.getName()) && entityField.getType().isAssignableFrom(dtoField.getType())) {
//            entityField.set(entity, dtoValue);
//          }
//        }
//      }
//
//      return entity;
//    }
//  }
//
//  @Data
//  class MyDto {
//    private Long id;
//    private String name;
//
//    // Getter, Setter 생략
//  }
//
//  @Data
//  class MyEntity {
//    private Long id;
//    private String name;
//
//    // Getter,
//  }


}