package alek.app.symulator_ligi.controllers;

import alek.app.symulator_ligi.exceptions.MyException;
import alek.app.symulator_ligi.model.Player;
import alek.app.symulator_ligi.model.Poisiton;
import alek.app.symulator_ligi.model.dto.ModelMapper;
import alek.app.symulator_ligi.model.dto.PlayerWithNewContract;
import alek.app.symulator_ligi.repository.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.Optional;

@Controller
@RequestMapping("/manager")

public class ManagerController {
    private PlayerRepository playerRepository;

    public ManagerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;


    }


    @GetMapping("TablePlayer")
    public String getPlayers(Model model) {
        model.addAttribute("player", playerRepository.findAll());
        return "manager/tablePlayer";
    }


    @GetMapping("dashboard")
    public String managerDash() {
        return "manager/dashboard";
    }


    @GetMapping("addPlayer")
    public String addPlayers(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("position", Poisiton.values());

        return "manager/addPlayerByManager";

    }

    @PostMapping("addPlayer")
    public String addPlayersPost(Player player) {


        playerRepository.save(player);

        return "redirect:/manager/TablePlayer";
    }

    @GetMapping("modifyPension/{id}")
    public String playerModifyPension(Model model, @PathVariable Long id) {

        model.addAttribute("manager", playerRepository.findById(id).orElseThrow(NullPointerException::new));


        return "manager/modifyPlayerPension";

    }


    @GetMapping("modifyDate/{id}")
    public String playerModifyDate(Model model, @PathVariable Long id) {

        model.addAttribute("player", ModelMapper.fromPlayerToPlayerWithContract(playerRepository.findById(id).orElseThrow(NullPointerException::new)));
        return "manager/modifyPlayer";

    }


    @PostMapping("modifyPlayer")
    public String playerModifyPost(Model model, @ModelAttribute PlayerWithNewContract playerWithContract) {

        if (playerWithContract.getNewDate().compareTo(playerWithContract.getDate()) <= 0) {
            throw new MyException("Contract date is not correct");
        }

        System.out.println("**********************************************************");
        System.out.println(playerWithContract);
        System.out.println("**********************************************************");
        model.addAttribute("player", playerWithContract);
        return "manager/modifyPlayerPension";
    }

    @PostMapping("modifyPlayerPension")
    public String playerModifyPensionPost(Model model, @ModelAttribute PlayerWithNewContract playerWithContract) {

        if (playerWithContract.getNewPension().compareTo(playerWithContract.getPension()) <= 0) {
            throw new MyException("Contract pension is not correct");
        }

        Player player = playerRepository.findById(playerWithContract.getId()).orElseThrow(() -> new MyException("..."));
        player.setDate(playerWithContract.getNewDate());
        player.setPension(playerWithContract.getNewPension());
        playerRepository.save(player);

        return "redirect:/manager/TablePlayer";
    }


    @PostMapping("/deletePlayer")
    public String deletePlayers(Long id) {
        playerRepository.deleteById(id);
        return "redirect:/manager/TablePlayer";
    }


}
