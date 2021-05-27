package jp.co.aoterp.web.dto;

import jp.co.aoterp.domain.member.Members;
import lombok.Getter;


@Getter
public class MemberListResponseDto {

    private Long id;
    private String email;
    private String name;
    private String department;
    private String position;
    private Long age;
    private Long sex;
    private String nationality;

    public MemberListResponseDto(Members members) {
        this.id = members.getId();
        this.email = members.getEmail();
        this.name = members.getName();
//        this.department = members.getDepartment();
//        this.position = members.getPosition();
        this.age = members.getAge();
        this.sex = members.getSex();
//        this.nationality = members.getNationality();
    }
}
