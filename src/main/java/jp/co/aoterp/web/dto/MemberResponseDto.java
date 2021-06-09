package jp.co.aoterp.web.dto;

import jp.co.aoterp.constant.*;
import jp.co.aoterp.domain.member.Members;
import jp.co.aoterp.domain.skill.Skill;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


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
    private String nearestStation;
    private String phone;
    private List<SkillDto> skills;

    public MemberResponseDto(Members members) {
        this.id = members.getId();
        this.email = members.getEmail();
        this.name = members.getName();
        this.nearestStation = members.getNearestStation();
        this.phone = members.getPhone();
        this.employmentType = EmploymentType.getNameBy(members.getEmploymentType());
        this.enteredDate = members.getEnteredDate();
        this.department = Department.getNameBy(members.getDepartment());
        this.position = Position.getNameBy(members.getPosition());
        this.dateOfBirth = members.getDateOfBirth();
        this.sex = Sex.getNameBy(members.getSex());
        this.nationality = Nationality.getNameBy(members.getNationality());
    }

    public MemberResponseDto(Members member, List<Skill> skills) {
        this(member);
        this.skills = skills.stream()
                .map(SkillDto::new)
                .collect(Collectors.toList());
    }

}
