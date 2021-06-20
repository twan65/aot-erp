package jp.co.aoterp.web.api.service;

import jp.co.aoterp.constant.MessageCode;
import jp.co.aoterp.domain.annual.leave.AnnualLeaveRepository;
import jp.co.aoterp.domain.member.MemberRepository;
import jp.co.aoterp.domain.member.Members;
import jp.co.aoterp.error.NoSearchResultException;
import jp.co.aoterp.web.dto.AnnualLeaveResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AnnualLeaveService {

    private final AnnualLeaveRepository annualLeaveRepository;
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public AnnualLeaveResponseDto findByMemberId(long memberId) {
        Members member = memberRepository.findById(memberId).orElseThrow(() ->
                new NoSearchResultException(MessageCode.E00005)
        );

        return new AnnualLeaveResponseDto(member, member.getAnnualLeave());
    }


}
