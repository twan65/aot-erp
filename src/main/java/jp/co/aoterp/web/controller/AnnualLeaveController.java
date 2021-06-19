package jp.co.aoterp.web.controller;

import jp.co.aoterp.constant.ViewNames;
import jp.co.aoterp.web.api.service.AnnualLeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class AnnualLeaveController {

    private final AnnualLeaveService annualLeaveService;

    @GetMapping("/al/save")
    public String save(Model model) {
        return ViewNames.ANNUAL_LEAVE_SAVE_PATH;
    }
}
