package nl.developers.demo.contollers;

import java.util.List;

import nl.developers.demo.objects.Game;
import nl.developers.demo.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/developers_nl")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping(path = "/game")
    public @ResponseBody void addGame(@RequestParam String name, @RequestParam String game) {

    }

    @GetMapping(path = "/game")
    public @ResponseBody List<Game> getAllGames(Model model) {
        List<Game> gameList = gameService.findAll();
        model.addAttribute("gameList", gameList);
        return gameList;

    }
}