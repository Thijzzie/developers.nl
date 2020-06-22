package nl.developers.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import nl.developers.demo.objects.Game;
import nl.developers.demo.objects.Player;
import nl.developers.demo.repos.GameRepo;
import nl.developers.demo.repos.PlayerRepo;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    @Autowired
    private GameRepo gameRepo;
    @Autowired
    private PlayerRepo playerRepo;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        logger.info("initializing games");
        
        Game g1 = Game.builder()
                .id(1L)
                .name("Terra Mystica")
                .build();
        gameRepo.save(g1);
        
        Game g2 = Game.builder()
                .id(2L)
                .name("7 Wonders")
                .build();
        gameRepo.save(g2);
        
        logger.info("initializing players");

        //TODO: The first player fails. Figure out why and fix it.
        Player p1 = Player.builder()
                .id(1L)
                .name("Thijs")
                .game(g1)
                .build();
        playerRepo.save(p1);

        Player p2 = Player.builder()
                .id(2L)
                .name("Susan")
                .game(g1)
                .build();
        playerRepo.save(p2);

        Player p3 = Player.builder()
                .id(3L)
                .name("Bart")
                .game(g2)
                .build();
        playerRepo.save(p3);

    }
}