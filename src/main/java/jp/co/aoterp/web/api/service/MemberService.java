package jp.co.aoterp.web.api.service;

import jp.co.aoterp.domain.member.MemberRepository;
import jp.co.aoterp.web.dto.MemberListResponseDto;
import jp.co.aoterp.web.dto.MemberSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    /**
     * 検索条件によるメンバー一覧取得
     *
     * @return メンバー一覧
     */
    @Transactional(readOnly = true)
    public List<MemberListResponseDto> findAll() {
        return memberRepository.findAll().stream()
                .map(MemberListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(MemberSaveRequestDto requestDto) {
        return memberRepository.save(requestDto.toEntity()).getId();
    }
}
