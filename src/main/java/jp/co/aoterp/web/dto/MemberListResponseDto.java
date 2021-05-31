package jp.co.aoterp.web.dto;

import jp.co.aoterp.domain.member.Members;
import lombok.Getter;

import java.time.LocalDate;


@Getter
public class MemberListResponseDto {

    private Long id;
    private String email;
    private String name;
    private Long department;
    private Long employmentType;
    private LocalDate enteredDate;
    private Long position;
    private Long age;
    private Long sex;
    private Long nationality;

    public MemberListResponseDto(Members members) {
        this.id = members.getId();
        this.email = members.getEmail();
        this.name = members.getName();
        this.employmentType = members.getEmploymentType();
        this.enteredDate = members.getEnteredDate();
        this.department = members.getDepartment();
        this.position = members.getPosition();
        this.age = members.getAge();
        this.sex = members.getSex();
        this.nationality = members.getNationality();
    }

}
