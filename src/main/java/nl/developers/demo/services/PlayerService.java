package nl.developers.demo.services;

import java.util.ArrayList;
import java.util.List;

import javassist.NotFoundException;
import nl.developers.demo.objects.Game;
import nl.developers.demo.objects.Player;
import nl.developers.demo.repos.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepo playerRepo;
    @Autowired
    private GameService gameService;

    public List<Player> findAll() {

        List<Player> playerList = new ArrayList<>();
        System.out.println(playerRepo.findAll());
        playerRepo.findAll().forEach((player) -> playerList.add(player));
        System.out.println(playerList);
        return playerList;

    }
    
    public void createPlayer(String name, long gameId) throws NotFoundException {
        Game game = gameService.findGameById(gameId).orElseThrow(() -> new NotFoundException("No game found with Id:" + gameId));
        
    }
}
