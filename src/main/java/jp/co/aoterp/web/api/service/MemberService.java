package jp.co.aoterp.web.api.service;

import jp.co.aoterp.constant.MessageCode;
import jp.co.aoterp.domain.member.MemberRepository;
import jp.co.aoterp.domain.member.MemberSpecification;
import jp.co.aoterp.domain.member.Members;
import jp.co.aoterp.domain.skill.Skill;
import jp.co.aoterp.domain.skill.SkillRepository;
import jp.co.aoterp.error.NoSearchResultException;
import jp.co.aoterp.web.dto.MemberResponseDto;
import jp.co.aoterp.web.dto.MemberSaveRequestDto;
import jp.co.aoterp.web.dto.MemberSearchRequestDto;
import jp.co.aoterp.web.dto.MemberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.thymeleaf.util.ListUtils;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final SkillRepository skillRepository;

    @Transactional(readOnly = true)
    public Page<MemberResponseDto> findAllBy(MemberSearchRequestDto requestDto, Pageable pageable) {
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

        spec = spec.and(MemberSpecification.dateOfBirth(requestDto.getDateOfBirthFrom(), requestDto.getDateOfBirthTo()));
        spec = spec.and(MemberSpecification.enteredDate(requestDto.getEnteredDateFrom(), requestDto.getEnteredDateTo()));


        return memberRepository.findAll(spec, pageable).map(MemberResponseDto::new);
    }

    /**
     * 検索条件によるメンバー一覧取得
     *
     * @return メンバー一覧
     */
    @Transactional(readOnly = true)
    public Page<MemberResponseDto> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable).map(MemberResponseDto::new);
    }

    public MemberResponseDto findById(Long id) {
        Members member = memberRepository.findById(id)
                .orElseThrow(() -> new NoSearchResultException(MessageCode.E00005));

        return new MemberResponseDto(member, member.getSkills());
    }

    @Transactional
    public Long save(MemberSaveRequestDto requestDto) {
        return memberRepository.save(requestDto.toEntity()).getId();
    }


    @Transactional
    public Long update(long id, MemberUpdateRequestDto requestDto) {
        Members member = memberRepository.findById(id)
                .orElseThrow(() -> new NoSearchResultException(MessageCode.E00005));

        member.update(requestDto.getName(), requestDto.getSex(), requestDto.getNationality(),
                requestDto.getNearestStation(), requestDto.getPhone());

        skillRepository.deleteAll();
        if (!ListUtils.isEmpty(requestDto.getSkills())) {
            List<Skill> skills = requestDto.getSkills().stream()
                    .map(dto -> dto.toEntity(id))
                    .collect(Collectors.toList());
            skillRepository.saveAll(skills);
        }
        return id;
    }
}
