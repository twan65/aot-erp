package jp.co.aoterp.web.api.controller;

import jp.co.aoterp.web.api.service.MemberService;
import jp.co.aoterp.web.dto.MemberSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/v1/m")
    public Long save(@RequestBody @Valid MemberSaveRequestDto requestDto) {
        return memberService.save(requestDto);
    }
}
