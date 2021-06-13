package jp.co.aoterp.web.dto;

import jp.co.aoterp.domain.skill.Skill;
import lombok.Getter;

@Getter
public class SkillDto {

    private String name;
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
