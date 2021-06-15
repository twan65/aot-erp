package jp.co.aoterp.web.dto;

import jp.co.aoterp.domain.skill.Skill;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
public class SkillDto {

    @NotBlank(message = "{E00002}")
    private String name;

    @Min(value = 1, message = "{E00003}")
    @Max(value = 100, message = "{E00003}")
    private int percent;

    public SkillDto(Skill skill) {
        this.name = skill.getName();
        this.percent = skill.getPercent();
    }

    public SkillDto(String name, int percent) {
        this.name = name;
        this.percent = percent;
    }

    public Skill toEntity(long memberId) {
        return Skill.builder()
                .name(name)
                .memberId(memberId)
                .percent(percent)
                .build();
    }
}
