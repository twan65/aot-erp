package jp.co.aoterp.validation.validator;

import jp.co.aoterp.validation.DateFormatValid;
import org.thymeleaf.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** 日付フォーマットのバリデータ */
public class DateFormatValidator implements ConstraintValidator<DateFormatValid, String> {

  @Override
  public void initialize(DateFormatValid constraintAnnotation) {}

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    // 未入力は未入力チェックのアノテーションを利用
    if (StringUtils.isEmpty(value)) {
      return true;
    }

    try {
      LocalDate.parse(value, DateTimeFormatter.ISO_DATE);
    } catch (Exception ex) {
      return false;
    }

    // 正常
    return true;
  }
}
