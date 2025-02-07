package U5_W1_d5.gestioni.Utente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, String> {
    Optional<Utente> findByUsername(String username);
}
