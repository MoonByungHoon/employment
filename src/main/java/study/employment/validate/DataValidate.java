package study.employment.validate;

public class DataValidate {

  public void nullPointValidate(Object object) {
    if (object == null) {
      throw new NullPointerException("데이터가 없습니다.");
    }
  }
}
