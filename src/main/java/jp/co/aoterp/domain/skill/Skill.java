package jp.co.aoterp.domain.skill;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "member_id")
    private long memberId;

    @Column
    private String name;

    @Column
    private int percent;

    @Builder
    public Skill(String name, int percent, long memberId) {
        this.memberId = memberId;
        this.name = name;
        this.percent = percent;
    }
}
