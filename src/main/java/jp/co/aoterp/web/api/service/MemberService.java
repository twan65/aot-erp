package jp.co.aoterp.web.api.service;

import jp.co.aoterp.domain.member.MemberRepository;
import jp.co.aoterp.domain.member.MemberSpecification;
import jp.co.aoterp.domain.member.Members;
import jp.co.aoterp.web.dto.MemberListResponseDto;
import jp.co.aoterp.web.dto.MemberSaveRequestDto;
import jp.co.aoterp.web.dto.MemberSearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Page<MemberListResponseDto> findAllBy(MemberSearchRequestDto requestDto, Pageable pageable) {
        Specification<Members> spec = Specification.where(null);
        if (!StringUtils.isEmpty(requestDto.getName())) {
            spec = spec.and(MemberSpecification.likeName(requestDto.getName()));
        }
        if (requestDto.getDepartment() != -1) {
            spec = spec.and(MemberSpecification.equalDepartment(requestDto.getDepartment()));
        }
        if (requestDto.getEmploymentType() != -1) {
            spec = spec.and(MemberSpecification.equalEmploymentType(requestDto.getEmploymentType()));
        }

        spec = spec.and(MemberSpecification.age(requestDto.getAgeFrom(), requestDto.getAgeTo()));
        spec = spec.and(MemberSpecification.enteredDate(requestDto.getEnteredDateFrom(), requestDto.getEnteredDateTo()));


        return memberRepository.findAll(spec, pageable).map(MemberListResponseDto::new);
    }

    /**
     * 検索条件によるメンバー一覧取得
     *
     * @return メンバー一覧
     */
    @Transactional(readOnly = true)
    public Page<MemberListResponseDto> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable).map(MemberListResponseDto::new);
    }

    @Transactional
    public Long save(MemberSaveRequestDto requestDto) {
        return memberRepository.save(requestDto.toEntity()).getId();
    }
}
