package jp.co.aoterp.web.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
public class MemberUpdateRequestDto {

    @NotBlank(message = "{E00002}")
    private String name;

    @Min(value = 1, message = "{E00003}")
    @Max(value = 3, message = "{E00003}")
    private Integer sex;

    @Min(value = 1, message = "{E00003}")
    @Max(value = 5, message = "{E00003}")
    private Integer nationality;

    @NotBlank(message = "{E00002}")
    private String nearestStation;

    @NotBlank(message = "{E00002}")
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
