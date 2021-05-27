package jp.co.aoterp.web.api.controller;

import jp.co.aoterp.web.api.service.MemberService;
import jp.co.aoterp.web.dto.MemberSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/v1/m")
    public Long save(@RequestBody MemberSaveRequestDto requestDto) {
        return memberService.save(requestDto);
    }
}
