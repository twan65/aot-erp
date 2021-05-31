package jp.co.aoterp.web.dto;

import jp.co.aoterp.domain.member.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @Size(min = 1, max = 3, message = "{E00003}")
    private Long employmentType;

    // TODO: Localdateに変更
    @NotBlank(message = "{E00002}")
    private String enteredDate;

    @Size(min = 1, max = 3, message = "{E00003}")
    private Long department;

    @Size(min = 1, max = 5, message = "{E00003}")
    private Long position;

    // TODO: 生年月日に変更
    private Long age;

    @Size(min = 1, max = 3, message = "{E00003}")
    private Long sex;

    @Size(min = 1, max = 5, message = "{E00003}")
    private Long nationality;

    @Builder
    public MemberSaveRequestDto(String email, String name, Long employmentType, String enteredDate, Long department, Long position, Long age, Long sex, Long nationality) {
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
