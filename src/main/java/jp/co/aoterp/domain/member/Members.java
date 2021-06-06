package jp.co.aoterp.domain.member;

import jp.co.aoterp.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
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

    @Column(length = 2, nullable = false)
    private int age;

    @Column(length = 1, nullable = false)
    private int sex;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 1, nullable = false)
    private int nationality;

    @Column(length = 50, nullable = false)
    private String createdBy;

    @Column(length = 50, nullable = false)
    private String updatedBy;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Builder
    public Members(String email, String name, Integer employmentType, LocalDate enteredDate, Integer department, Integer position, Integer age, Integer sex, Integer nationality) {
        this.email = email;
        this.name = name;
        this.employmentType = employmentType;
        this.enteredDate = enteredDate;
        this.department = department;
        this.position = position;
        this.age = age;
        this.sex = sex;
        this.nationality = nationality;
        this.createdBy = "testUser1"; // TODO: ログインユーザーに変更
        this.updatedBy = "testUser1"; // TODO: ログインユーザーに変更
        this.isDeleted = false;
    }
}
