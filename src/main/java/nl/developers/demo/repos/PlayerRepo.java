package nl.developers.demo.repos;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import nl.developers.demo.objects.Player;

@Repository
public interface PlayerRepo extends CrudRepository<Player, Long> {
    
}
