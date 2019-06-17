package alek.app.symulator_ligi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("errorMessage", "");
        return "security/loginPage";
    }

    @GetMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("errorMessage", "Nieprawidłowe dane logowania");
        return "security/loginPage";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(Model model) {
        model.addAttribute("info", "ACCESS DENIED!!!!");
        return "security/accessDenied";
    }
}
