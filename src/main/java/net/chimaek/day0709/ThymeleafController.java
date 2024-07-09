package net.chimaek.day0709;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/index123")
    public String index(Model model) {
        model.addAttribute("name", "쏘굿");
        model.addAttribute("name2", "굿굿");
        model.addAttribute("label1", "로긴");
        return "index";
    }
}
