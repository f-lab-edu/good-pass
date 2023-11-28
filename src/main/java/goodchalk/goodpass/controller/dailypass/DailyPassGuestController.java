package goodchalk.goodpass.controller.dailypass;

import goodchalk.goodpass.dto.DailyPass;
import goodchalk.goodpass.repository.ClimbingGymRepository;
import goodchalk.goodpass.service.ClimbingGymService;
import goodchalk.goodpass.service.DailyPassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.PriorityQueue;

@Controller
@RequestMapping("/{climbingGymName}/daily-pass")
@RequiredArgsConstructor
public class DailyPassGuestController {
    private final DailyPassService dailyPassService;
    private final ClimbingGymService climbingGymService;

    @GetMapping("/save-form")
    public String showSaveForm(@PathVariable("climbingGymName") String climbingGymName, Model model) {
        model.addAttribute("climbingGymName", climbingGymName);
        return "save-form/daily-pass";
    }

    @GetMapping("/save")
    public String showSaveCompete(@PathVariable("climbingGymName") String climbingGymName, Model model) {
        model.addAttribute("climbingGymName", climbingGymName);
        return "/save-form/complete";
    }

    @PostMapping("/save")
    public String save(@PathVariable("climbingGymName") String climbingGymName,
                       @RequestBody DailyPass dailyPass,
                       Model model) {
        Long climbingGymId = climbingGymService.findBy(climbingGymName);
        dailyPass.setClimbingGymId(climbingGymId);
        dailyPassService.save(dailyPass);

        model.addAttribute(climbingGymName);
        return "redirect:/" + climbingGymName + "/daily/save";
    }
}
