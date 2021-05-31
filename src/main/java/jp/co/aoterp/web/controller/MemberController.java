package jp.co.aoterp.web.controller;

import jp.co.aoterp.constant.ViewNames;
import jp.co.aoterp.web.api.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/m/search")
    public String findAllMembers(@PageableDefault(size = 20, sort = "name", direction = Sort.Direction.ASC) Pageable pageable
    , Model model) {
        model.addAttribute("members", memberService.findAll(pageable));
        return ViewNames.MEMBER_SEARCH_PATH;
    }

    @GetMapping("/m/save")
    public String saveMember(Model model) {
        return ViewNames.MEMBER_SAVE_PATH;
    }
}
