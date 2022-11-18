package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User1;
import web.service.MyService;

@Controller
@RequestMapping("/")
public class UsersController {



    @GetMapping
    public String show(Model model) {
        return getUsersView(model);
    }

    @PostMapping
    public String show2(Model model) {
        return getUsersView(model);
    }

    private String getUsersView(Model model) {
        model.addAttribute("message", "Список пользователей");
        model.addAttribute("url", "/users");
        return "index";
    }

    private final MyService<User1> userService;


    public UsersController(MyService<User1> userService) {
        this.userService = userService;
        addUsers();
    }
    //--- CREATE

    /***
     * Подготовить объект User для сохранения в базу
     */
    @GetMapping("users/new")
    public String createForm(@ModelAttribute("user") User1 user) {
        return "new";
    }
// тут
    /***
     * Сохранить в базу
     */
    @PostMapping ("users")
    public String create(@ModelAttribute("user") User1 user) {
        // параметры собираются сразу в модель User
        userService.create(user);
        return "redirect:users";
    }

    //--- READ

    /***
     * Получить всех пользователей
     */
    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userService.getList());
        return "all";
    }

    /***
     * Получить одного пользователя
     */
    @GetMapping("users/{id}")
    public String read(Model model, @PathVariable(name = "id") long id) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    //--- UPDATE

    /***
     * Подготовить изменения для объекта User
     */
    @GetMapping("(users/{id}/edit")
    public String editForm(Model model, @PathVariable() long id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    /***
     * Сохранить изменённого пользователя
     */
    @PatchMapping("users/{id}")
    public String edit(@ModelAttribute("user") User1 user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    //--- DELETE

    /***
     * Удалить пользователя (подготовки объекта User не требуется)
     */
    @DeleteMapping("users/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
//
//    //--- TECHNICAL
//
//    /***
//     * Подготовим список пользователей в базе
//     */
    private void addUsers() {
        userService.create(new User1("Степан", "Иванов"));
        userService.create(new User1("Иван", "Петров"));
        userService.create(new User1("Света", "Вихрь"));
        userService.create(new User1("Алина", "Хац"));
    }

}

