package jp.co.aoterp.web.api.controller;

import jp.co.aoterp.web.api.service.MemberService;
import jp.co.aoterp.web.dto.MemberResponseDto;
import jp.co.aoterp.web.dto.MemberSaveRequestDto;
import jp.co.aoterp.web.dto.MemberSearchRequestDto;
import jp.co.aoterp.web.dto.MemberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/v1/m/search")
    public Page<MemberResponseDto> findAllBy(@RequestBody MemberSearchRequestDto requestDto
            , @PageableDefault(size = 20, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        return memberService.findAllBy(requestDto, pageable);
    }

    @PutMapping("/api/v1/m/{id}")
    public Long update(@PathVariable long id, @RequestBody MemberUpdateRequestDto requestDto) {
        return memberService.update(id, requestDto);
    }

    @PostMapping("/api/v1/m")
    public Long save(@RequestBody @Valid MemberSaveRequestDto requestDto) {
        return memberService.save(requestDto);
    }
}
