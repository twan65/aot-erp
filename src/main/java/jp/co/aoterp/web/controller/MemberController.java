package jp.co.aoterp.web.controller;

import jp.co.aoterp.constant.*;
import jp.co.aoterp.error.NoSearchResultException;
import jp.co.aoterp.utils.MessageHelper;
import jp.co.aoterp.web.api.service.MemberService;
import jp.co.aoterp.web.dto.MemberSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;
    private final MessageHelper messageHelper;

    @GetMapping("/m/search")
    public String search(Model model, @ModelAttribute("error") String error) {
        // TODO: 仮データ
        for (int i = 1; i < 66; i++) {

            MemberSaveRequestDto dto = MemberSaveRequestDto.builder().email("test" + i + "@co.jp")
                    .name("test" + i).dateOfBirth("1990-05-05")
                    .department(1).employmentType(2).enteredDate("2020-12-12")
                    .nationality(2).sex(1).position(4).build();
            memberService.save(dto);

        }

        model.addAttribute("departments", Department.map());
        model.addAttribute("employmentTypes", EmploymentType.map());

        return ViewNames.MEMBER_SEARCH_PATH;
    }

    @GetMapping("/m/{id}")
    public String findDetail(@PathVariable long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("member", memberService.findById(id));
        } catch(NoSearchResultException ex) {
            redirectAttributes.addFlashAttribute("error", messageHelper.getMessage(ex.getMessageCode()));
            return "redirect:/m/search";
        }

        return ViewNames.MEMBER_DETAIL_PATH;
    }

    @GetMapping("/m/edit/{id}")
    public String edit(@PathVariable long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("member", memberService.findById(id));
        } catch(NoSearchResultException ex) {
            redirectAttributes.addFlashAttribute("error", messageHelper.getMessage(ex.getMessageCode()));
            // TODO: リダイレクトはTOPへ
            return "redirect:/m/search";
        }
        return ViewNames.MEMBER_EDIT_PATH;
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
