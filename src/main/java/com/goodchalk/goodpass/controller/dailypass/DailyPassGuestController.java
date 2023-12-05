package com.goodchalk.goodpass.controller.dailypass;

import com.goodchalk.goodpass.domain.DailyPass;
import com.goodchalk.goodpass.dto.request.DailyPassSaveDto;
import com.goodchalk.goodpass.service.ClimbingGymService;
import com.goodchalk.goodpass.service.DailyPassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/{climbingGymId}/daily-pass")
@RequiredArgsConstructor
public class DailyPassGuestController {
    private final DailyPassService dailyPassService;
    private final ClimbingGymService climbingGymService;

    @GetMapping("/save-form")
    public String showSaveForm(@PathVariable("climbingGymId") Long climbingGymId, Model model) {
        //String climbingGymName = climbingGymService.findNameBy(climbingGymId);
        model.addAttribute("climbingGymId", climbingGymId);
        return "save-form/daily-pass";
    }

    @GetMapping("/save")
    public String showSaveCompete(@PathVariable("climbingGymId") Long climbingGymId, Model model) {
        model.addAttribute("climbingGymId", climbingGymId);
        return "save-form/complete";
    }

    @GetMapping("/signature-form")
    public String showSignatureForm(@PathVariable("climbingGymId") Long climbingGymId, Model model) {
        model.addAttribute("climbingGymId", climbingGymId);
        return "save-form/signature-form";
    }

    @PostMapping("/save")
    public String save(@PathVariable("climbingGymId") Long climbingGymId, @RequestBody DailyPassSaveDto dailyPassSaveDto, Model model) {
        DailyPass dailyPass = DailyPass.create(climbingGymId,
                dailyPassSaveDto.getUserName(),
                dailyPassSaveDto.getContact(),
                dailyPassSaveDto.getDailyUseGymContract(),
                dailyPassSaveDto.getPrivacyContract(),
                dailyPassSaveDto.getSubmitTime());
        dailyPassService.save(dailyPass);

        model.addAttribute(climbingGymId);
        return "redirect:/" + climbingGymId + "/daily-pass/signature-form";
    }

    @PostMapping("/save-signature")
    public String saveSignature(@PathVariable("climbingGymId") Long climbingGymId, Model model) {
        DailyPass dailyPass = null;
        //dailyPassService.save(dailyPass);

        model.addAttribute(climbingGymId);
        return "redirect:/" + climbingGymId + "/daily-pass/save";
    }
}
