package jp.co.aoterp.domain.member;

import jp.co.aoterp.domain.BaseTimeEntity;
import jp.co.aoterp.domain.annual.leave.AnnualLeave;
import jp.co.aoterp.domain.skill.Skill;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Where(clause = "is_deleted = false")
public class Members extends BaseTimeEntity {

    @Id // PKフィールドを示す
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 1, nullable = false)
    private int employmentType;

    @Column(nullable = false)
    private LocalDate enteredDate;

    @Column(length = 1, nullable = false)
    private int department;

    @Column(length = 1, nullable = false)
    private int position;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(length = 1, nullable = false)
    private int sex;

    @Column(length = 50, nullable = false)
    private String name;

    @Column
    private String nearestStation;

    @Column(length = 13)
    private String phone;

    @Column(length = 1, nullable = false)
    private int nationality;

    @Column(length = 50, nullable = false)
    private String createdBy;

    @Column(length = 50, nullable = false)
    private String updatedBy;

    @Column(nullable = false)
    private boolean isDeleted;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private List<Skill> skills;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private AnnualLeave annualLeave;

    @Builder
    public Members(String email, String name, Integer employmentType, LocalDate enteredDate, Integer department, Integer position, LocalDate dateOfBirth, Integer sex, Integer nationality) {
        this.email = email;
        this.name = name;
        this.employmentType = employmentType;
        this.enteredDate = enteredDate;
        this.department = department;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.nationality = nationality;
        this.createdBy = "testUser1"; // TODO: ログインユーザーに変更
        this.updatedBy = "testUser1"; // TODO: ログインユーザーに変更
        this.isDeleted = false;
    }

    public void update(String name, String nearestStation, String phone) {
        this.name = name;
        this.nearestStation = nearestStation;
        this.phone = phone;
    }
}
