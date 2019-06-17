package alek.app.symulator_ligi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping({"/", ""})
    public String index() {
        return "index";
    }

    @GetMapping({"/test", ""})
    public String xD() {
        return "index";
    }


    @GetMapping("/playerTable")
    public String table() {
        return "admin/player";
    }

}
