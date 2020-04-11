package ru.javamentor.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.model.User;
import ru.javamentor.service.UserRoleService;
import ru.javamentor.service.UserService;

import java.util.List;
import java.util.Map;


@Controller
public class UserController {

    private final UserService userService;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UserRoleService userRoleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = "/users")
    public ModelAndView showUsers() {
        List<User> listUser = userService.listAll();
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("listUser", listUser);
        return mav;
    }

    @GetMapping(value = "/users/new")
    public String newUserForm(Map<String, Object> model) {
        model.put("user", new User());
        model.put("roles", userRoleService.listAll());
        return "new_user";
    }

    @PostMapping(value = "/users/save")
    public String saveUser(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/users/edit")
    public ModelAndView editUserForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = userService.get(id);
        mav.addObject("user", user);
        mav.addObject("roles", userRoleService.listAll());
        return mav;
    }

    @GetMapping("/users/delete")
    public String deleteUserForm(@RequestParam long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
