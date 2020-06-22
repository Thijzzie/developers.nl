package nl.developers.demo.contollers;

import java.util.List;

import javassist.NotFoundException;
import nl.developers.demo.objects.Player;
import nl.developers.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/developers_nl")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping(path = "/player")
    public @ResponseBody void addPlayer(@RequestParam String name, @RequestParam Long gameId) throws NotFoundException {
        playerService.createPlayer(name, gameId);
    }

    @GetMapping(path = "/player")
    public @ResponseBody List<Player> getAllPlayers() {
        return playerService.findAll();

    }

}
