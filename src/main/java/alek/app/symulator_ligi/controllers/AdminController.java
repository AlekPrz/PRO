package alek.app.symulator_ligi.controllers;


import alek.app.symulator_ligi.model.Player;
import alek.app.symulator_ligi.model.Poisiton;
import alek.app.symulator_ligi.repository.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")

public class AdminController {
    private PlayerRepository playerRepository;

    public AdminController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;


    }


    @GetMapping("TablePlayer")
    public String getPlayers(Model model) {
        model.addAttribute("player", playerRepository.findAll());
        return "admin/player";
    }


    @GetMapping("dashboard")
    public String managerDash() {
        return "admin/dashboard";
    }


    @GetMapping("addPlayer")
    public String addPlayers(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("position", Poisiton.values());

        return "admin/addPlayerByAdmin";

    }

    @PostMapping("addPlayer")
    public String addPlayersPost(Player player) {


        playerRepository.save(player);

        return "redirect:/admin/TablePlayer";
    }

    @PostMapping("/deletePlayer")
    public String deletePlayers(Long id) {
        playerRepository.deleteById(id);
        return "redirect:/admin/TablePlayer";
    }


}
