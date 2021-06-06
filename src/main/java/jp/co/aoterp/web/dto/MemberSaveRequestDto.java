package jp.co.aoterp.web.dto;

import jp.co.aoterp.domain.member.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {

    @NotBlank(message = "{E00002}")
    @Email(message = "{E00004}")
    private String email;

    @NotBlank(message = "{E00002}")
    private String name;

    @Min(value = 1, message = "{E00003}")
    @Max(value = 3, message = "{E00003}")
    private Integer employmentType;

    // TODO: Localdateに変更
    @NotBlank(message = "{E00002}")
    private String enteredDate;

    @Min(value = 1, message = "{E00003}")
    @Max(value = 3, message = "{E00003}")
    private Integer department;

    @Min(value = 1, message = "{E00003}")
    @Max(value = 5, message = "{E00003}")
    private Integer position;

    // TODO: 生年月日に変更
    private Integer age;

    @Min(value = 1, message = "{E00003}")
    @Max(value = 3, message = "{E00003}")
    private Integer sex;

    @Min(value = 1, message = "{E00003}")
    @Max(value = 5, message = "{E00003}")
    private Integer nationality;

    @Builder
    public MemberSaveRequestDto(String email, String name, Integer employmentType, String enteredDate, Integer department, Integer position, Integer age, Integer sex, Integer nationality) {
        this.email = email;
        this.name = name;
        this.employmentType = employmentType;
        this.enteredDate = enteredDate;
        this.department = department;
        this.position = position;
        this.age = age;
        this.sex = sex;
        this.nationality = nationality;
    }

    public Members toEntity() {
        return Members.builder()
                .email(email)
                .name(name)
                .employmentType(employmentType)
                .enteredDate(LocalDate.parse(enteredDate, DateTimeFormatter.ISO_DATE))
                .department(department)
                .position(position)
                .age(age)
                .sex(sex)
                .nationality(nationality)
                .build();
    }
}
