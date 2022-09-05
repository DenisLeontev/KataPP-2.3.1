package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.MyService;


@Controller
public class HomeController {

    private final MyService<User> userService;

    public HomeController(MyService<User> userService) {
        this.userService = userService;
        addUsers();
    }

    @GetMapping("/")
    public String showPage(ModelMap model) {
        model.clear();
        model.addAttribute("message", "Список людей");
        return "index";
    }

    @GetMapping("/users")
    public String showUsers(ModelMap model) {
        model.clear();
        model.addAttribute("users", userService.getList());
        return "users";
    }

    private void addUsers() {
        userService.add(new User("Степан", "Иванов"));
        userService.add(new User("Иван", "Петров"));
        userService.add(new User("Света", "Вихрь"));
        userService.add(new User("Алина", "Хац"));
    }

}
