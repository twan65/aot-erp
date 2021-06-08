package jp.co.aoterp.web.dto;

import jp.co.aoterp.constant.*;
import jp.co.aoterp.domain.member.Members;
import lombok.Getter;

import java.time.LocalDate;


@Getter
public class MemberResponseDto {

    private Long id;
    private String email;
    private String name;
    private String department;
    private String employmentType;
    private LocalDate enteredDate;
    private String position;
    private LocalDate dateOfBirth;
    private String sex;
    private String nationality;

    public MemberResponseDto(Members members) {
        this.id = members.getId();
        this.email = members.getEmail();
        this.name = members.getName();
        this.employmentType = EmploymentType.getNameBy(members.getEmploymentType());
        this.enteredDate = members.getEnteredDate();
        this.department = Department.getNameBy(members.getDepartment());
        this.position = Position.getNameBy(members.getPosition());
        this.dateOfBirth = members.getDateOfBirth();
        this.sex = Sex.getNameBy(members.getSex());
        this.nationality = Nationality.getNameBy(members.getNationality());
    }

}
