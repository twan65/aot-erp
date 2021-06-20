package jp.co.aoterp.domain.annual.leave;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class AnnualLeave {
    @Id
    @Column(name = "member_id")
    private long memberId;

    @Column
    private long totalCount;

    @Column
    private long ableCount;

    @Builder
    public AnnualLeave(long memberId, long totalCount, long ableCount) {
        this.memberId = memberId;
        this.totalCount = totalCount;
        this.ableCount = ableCount;
    }
}
