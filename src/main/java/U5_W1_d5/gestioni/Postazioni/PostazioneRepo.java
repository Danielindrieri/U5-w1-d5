package U5_W1_d5.gestioni.Postazioni;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepo extends JpaRepository<Postazione, Long> {
    List<Postazione> findByEdificioId(long id);
}