package U5_W1_d5.gestioni.Edificio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EdificioRepo extends JpaRepository<Edificio, Long> {
    List<Edificio> findByCittaIgnoreCase(String citta);
}
