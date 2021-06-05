package jp.co.aoterp.web.controller;

import jp.co.aoterp.constant.*;
import jp.co.aoterp.web.api.service.MemberService;
import jp.co.aoterp.web.dto.MemberSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/m/search")
    public String search(Model model) {
        for (int i = 0; i < 66; i++) {

            MemberSaveRequestDto dto = MemberSaveRequestDto.builder().email("test" + i + "@co.jp")
                    .name("test" + i).age(Long.valueOf(i))
                    .department(Long.valueOf(1)).employmentType(Long.valueOf(1)).enteredDate("2020-12-12")
                    .nationality(Long.valueOf(1)).sex(Long.valueOf(1)).position(Long.valueOf(1)).build();
            memberService.save(dto);

        }

        model.addAttribute("departments", Department.map());
        model.addAttribute("employmentTypes", EmploymentType.map());
        return ViewNames.MEMBER_SEARCH_PATH;
    }

    @GetMapping("/m/save")
    public String save(Model model) {
        model.addAttribute("departments", Department.map());
        model.addAttribute("employmentTypes", EmploymentType.map());
        model.addAttribute("nationalities", Nationality.map());
        model.addAttribute("positions", Position.map());
        model.addAttribute("sex", Sex.map());
        return ViewNames.MEMBER_SAVE_PATH;
    }
}
