package jp.co.aoterp.web.dto;

import jp.co.aoterp.domain.annual.leave.AnnualLeave;
import jp.co.aoterp.domain.member.Members;
import lombok.Getter;

@Getter
public class AnnualLeaveResponseDto {

    private long memberId;
    private String name;
    private long totalCount;
    private long ableCount;

   public AnnualLeaveResponseDto(Members member, AnnualLeave annualLeave) {
       this.memberId = member.getId();
       this.name = member.getName();
       this.totalCount = annualLeave.getTotalCount();
       this.ableCount = annualLeave.getAbleCount();
    }
}
