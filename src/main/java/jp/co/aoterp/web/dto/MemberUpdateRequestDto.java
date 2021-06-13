package jp.co.aoterp.web.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
public class MemberUpdateRequestDto {

    @NotBlank(message = "{E00002}")
    private String name;

    @NotBlank(message = "{E00002}")
    private String nearestStation;

    @NotBlank(message = "{E00002}")
    private String phone;

    private List<SkillDto> skills;

    @Builder
    public MemberUpdateRequestDto(String name,
                                  String nearestStation, String phone, List<SkillDto> skills) {
        this.name = name;
        this.nearestStation = nearestStation;
        this.phone = phone;
        this.skills = skills;
    }
}
