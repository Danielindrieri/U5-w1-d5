package U5_W1_d5.gestioni.Prenotazioni;

import U5_W1_d5.gestioni.Postazioni.Postazione;
import U5_W1_d5.gestioni.Utente.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data);
    List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);
    List<Prenotazione> findByUtente(Utente utente);
    List<Prenotazione> findByData(LocalDate data);
}