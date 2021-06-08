package jp.co.aoterp.web.dto;

import jp.co.aoterp.domain.member.Members;
import jp.co.aoterp.validation.DateFormatValid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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

    @NotBlank(message = "{E00002}")
    @DateFormatValid(message = "{E00004}")
    private String enteredDate;

    @Min(value = 1, message = "{E00003}")
    @Max(value = 3, message = "{E00003}")
    private Integer department;

    @Min(value = 1, message = "{E00003}")
    @Max(value = 5, message = "{E00003}")
    private Integer position;

    @NotBlank(message = "{E00002}")
    @DateFormatValid(message = "{E00004}")
    private String dateOfBirth;

    @Min(value = 1, message = "{E00003}")
    @Max(value = 3, message = "{E00003}")
    private Integer sex;

    @Min(value = 1, message = "{E00003}")
    @Max(value = 5, message = "{E00003}")
    private Integer nationality;

    @Builder
    public MemberSaveRequestDto(String email, String name, Integer employmentType, String enteredDate, Integer department, Integer position, String dateOfBirth, Integer sex, Integer nationality) {
        this.email = email;
        this.name = name;
        this.employmentType = employmentType;
        this.enteredDate = enteredDate;
        this.department = department;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
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
                .dateOfBirth(LocalDate.parse(dateOfBirth, DateTimeFormatter.ISO_DATE))
                .sex(sex)
                .nationality(nationality)
                .build();
    }
}
