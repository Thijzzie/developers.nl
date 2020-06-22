package nl.developers.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import nl.developers.demo.objects.Game;
import nl.developers.demo.repos.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepo gameRepo;

    public List<Game> findAll() {

        List<Game> gameList = new ArrayList<>();
        gameRepo.findAll().forEach((game) -> gameList.add(game));
        return gameList;

    }
    
    public Optional<Game> findGameById(long id) {
        return gameRepo.findById(id);
    }

}
