package nl.developers.demo.repos;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import nl.developers.demo.objects.Game;

@Repository
public interface GameRepo extends CrudRepository<Game, Long> {
    
}
