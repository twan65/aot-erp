package jp.co.aoterp.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class MemberUpdateRequestDto {

    private String name;
    private Integer sex;
    private Integer nationality;
    private String nearestStation;
    private String phone;
    private List<SkillDto> skills;

    @Builder
    public MemberUpdateRequestDto(String name, Integer sex, Integer nationality,
                                  String nearestStation, String phone, List<SkillDto> skills) {
        this.name = name;
        this.nearestStation = nearestStation;
        this.phone = phone;
        this.sex = sex;
        this.nationality = nationality;
        this.skills = skills;
    }
}
