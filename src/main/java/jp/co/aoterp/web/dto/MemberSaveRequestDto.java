package jp.co.aoterp.web.dto;

import jp.co.aoterp.domain.member.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {

    @NotBlank(message = "{E00001}")
    private String email;
    private String name;
    private Long department;
    private Long position;
    private Long age;
    private Long sex;
    private Long nationality;

    @Builder
    public MemberSaveRequestDto(String email, String name, Long department, Long position, Long age, Long sex, Long nationality) {
        this.email = email;
        this.name = name;
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
                .department(department)
                .position(position)
                .age(age)
                .sex(sex)
                .nationality(nationality)
                .build();
    }
}
