package jp.co.aoterp.web.controller;

import jp.co.aoterp.constant.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/m/search")
    public String findAll() {
        return ViewNames.MEMBER_SEARCH_PATH;
    }
}
