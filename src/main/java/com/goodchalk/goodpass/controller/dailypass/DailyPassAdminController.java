package com.goodchalk.goodpass.controller.dailypass;

import com.goodchalk.goodpass.domain.DailyPass;
import com.goodchalk.goodpass.service.DailyPassService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/{climbingGymName}/admin/daily-pass")
public class DailyPassAdminController {
    private final DailyPassService dailyPassService;
    @GetMapping
    public String listUpDailyPass(@PathVariable("climbingGymName") String climbingGymName, Model model) {
        log.info("climbingGymName = " + climbingGymName);
        //List<DailyPass> dailyPasses = dailyPassService.findAllBy(climbingGymName);
        List<DailyPass> dailyPasses = null;
        model.addAttribute("dailyPasses", dailyPasses);
        return "admin/daily-pass";
    }
}
