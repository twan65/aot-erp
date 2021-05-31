package jp.co.aoterp.web.api.controller;

import jp.co.aoterp.web.api.service.MemberService;
import jp.co.aoterp.web.dto.MemberListResponseDto;
import jp.co.aoterp.web.dto.MemberSaveRequestDto;
import jp.co.aoterp.web.dto.MemberSearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/v1/m")
    public Page<MemberListResponseDto> findAllBy(@RequestBody MemberSearchRequestDto requestDto
            , @PageableDefault(size = 20, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        return memberService.findAllBy(requestDto, pageable);
    }

    @PostMapping("/api/v1/m")
    public Long save(@RequestBody @Valid MemberSaveRequestDto requestDto) {
        return memberService.save(requestDto);
    }
}
