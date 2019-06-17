package alek.app.symulator_ligi.controllers;


import alek.app.symulator_ligi.model.Role;
import alek.app.symulator_ligi.model.User;
import alek.app.symulator_ligi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String registerGet(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", Role.values());
        return "users/register";
    }

    @PostMapping
    public String registerPost(@ModelAttribute User user, HttpServletRequest request) {
        userService.registerUser(user, request);
        return "redirect:/";
    }

    @GetMapping("/default")
    public String dashboardRole(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/admin/dashboard";
        }
        return "redirect:/manager/dashboard";
    }


}
