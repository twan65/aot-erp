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
}
