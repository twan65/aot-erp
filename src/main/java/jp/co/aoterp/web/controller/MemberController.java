package jp.co.aoterp.web.controller;

import jp.co.aoterp.constant.ViewNames;
import jp.co.aoterp.web.api.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/m/search")
    public String findAllMembers(Model model) {
        // TODO
//        model.addAttribute("members", memberService.findAll());
        return ViewNames.MEMBER_SEARCH_PATH;
    }

    @GetMapping("/m/save")
    public String saveMember(Model model) {
        // TODO
        return ViewNames.MEMBER_SAVE_PATH;
    }
}
