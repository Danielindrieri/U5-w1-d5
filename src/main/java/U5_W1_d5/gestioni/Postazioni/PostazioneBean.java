package U5_W1_d5.gestioni.Postazioni;

import U5_W1_d5.gestioni.Edificio.Edificio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostazioneBean {

    @Bean(name = "postazione1")
    public Postazione getPostazione1() {
        TipoPostazione tipo = TipoPostazione.PRIVATO;
        Edificio edificio = new Edificio();
        return new Postazione("Codice1", "Ufficio all'angolo", tipo, 10, edificio);
    }

    @Bean(name = "postazione2")
    public Postazione getPostazione2() {
        TipoPostazione tipo = TipoPostazione.SALA_RIUNIONI;
        Edificio edificio = new Edificio();
        return new Postazione("Codice2", "Sala riunioni di 20 posti", tipo, 20, edificio);
    }
}
