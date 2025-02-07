package U5_W1_d5.gestioni;

import U5_W1_d5.gestioni.Edificio.Edificio;
import U5_W1_d5.gestioni.Edificio.EdificioSRV;
import U5_W1_d5.gestioni.Postazioni.Postazione;
import U5_W1_d5.gestioni.Postazioni.PostazioneSRV;
import U5_W1_d5.gestioni.Postazioni.TipoPostazione;
import U5_W1_d5.gestioni.Utente.Utente;
import U5_W1_d5.gestioni.Utente.UtenteSRV;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Scanner;
import java.util.function.Supplier;

@Component
@Order(1)
public class DataRunner implements CommandLineRunner {

    @Autowired
    private UtenteSRV utenteSRV;

    @Autowired
    private EdificioSRV edificioSRV;

    @Autowired
    private PostazioneSRV postazioneSRV;

    private Faker faker = new Faker(Locale.ITALY);

    private Supplier<Utente> generateUser = () -> new Utente(
            faker.name().username(),
            faker.name().fullName(),
            faker.internet().emailAddress()
    );

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleziona: \n" + "1- Generazione DB \n" + "0- Esci");
        int cmd = scanner.nextInt();
        switch (cmd) {
            case 1:
                generateDB();
                break;
            default:
                System.out.println("Arrivederci");
                break;
        }
    }

    public void generateDB() {
        try {
            for (int i = 0; i < 50; i++) {
                try {
                    utenteSRV.save(generateUser.get());
                } catch (Exception e) {
                    System.err.println("Errore durante il salvataggio dell'utente: " + e.getMessage());
                }
            }

            Edificio edificio1 = new Edificio("Edificio1", "Descrizione Edificio 1", "Roma");
            Edificio edificio2 = new Edificio("Edificio2", "Descrizione Edificio 2", "Milano");

            edificioSRV.save(edificio1);
            edificioSRV.save(edificio2);

            Postazione postazione1 = new Postazione("Postazione1", "Descrizione Postazione 1", TipoPostazione.PRIVATO, 10, edificio1);
            Postazione postazione2 = new Postazione("Postazione2", "Descrizione Postazione 2", TipoPostazione.SALA_RIUNIONI, 15, edificio2);

            postazioneSRV.save(postazione1);
            postazioneSRV.save(postazione2);
        } catch (Exception e) {
            System.err.println("Errore durante la generazione del DB: " + e.getMessage());
        }
    }
}
