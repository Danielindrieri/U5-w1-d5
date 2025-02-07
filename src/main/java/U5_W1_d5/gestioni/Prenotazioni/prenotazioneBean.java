package U5_W1_d5.gestioni.Prenotazioni;
import U5_W1_d5.gestioni.Postazioni.Postazione;
import U5_W1_d5.gestioni.Postazioni.PostazioneSRV;
import U5_W1_d5.gestioni.Utente.Utente;
import U5_W1_d5.gestioni.Utente.UtenteSRV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class prenotazioneBean implements CommandLineRunner {

    @Autowired
    private PrenotazioneSRV prenotazioneSRV;

    @Autowired
    private PostazioneSRV postazioneSRV;

    @Autowired
    private UtenteSRV utenteSRV;

    @Override
    public void run(String... args) throws Exception {

        try {
            Utente utente1 = new Utente("utente1", "Mario Rossi", "mario.rossi@example.com");
            Utente utente2 = new Utente("utente2", "Luigi Verdi", "luigi.verdi@example.com");
            utenteSRV.save(utente1);
            utenteSRV.save(utente2);

            Postazione postazione1 = postazioneSRV.findById(1L);
            Postazione postazione2 = postazioneSRV.findById(2L);


            Prenotazione prenotazione1 = new Prenotazione(
                    postazione1,
                    utente1,
                    LocalDateTime.of(2025, 2, 10, 10, 0)
            );

            Prenotazione prenotazione2 = new Prenotazione(
                    postazione2,
                    utente2,
                    LocalDateTime.of(2025, 2, 11, 14, 0)
            );

            prenotazioneSRV.save(prenotazione1);
            prenotazioneSRV.save(prenotazione2);

            System.out.println("Prenotazioni create con successo!");
        } catch (Exception e) {
            System.err.println("Errore durante la generazione delle prenotazioni: " + e.getMessage());
        }
    }
}

