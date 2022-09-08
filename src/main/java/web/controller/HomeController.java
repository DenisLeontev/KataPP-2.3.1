package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String show(Model model) {
        return getHomeView(model);
    }

    @PostMapping
    public String show2(Model model) {
        return getHomeView(model);
    }

    private String getHomeView(Model model) {
        model.addAttribute("message", "Список людей");
        model.addAttribute("url", "/users");
        return "index";
    }
}
