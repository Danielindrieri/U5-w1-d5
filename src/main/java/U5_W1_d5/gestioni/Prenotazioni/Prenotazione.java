package U5_W1_d5.gestioni.Prenotazioni;

import U5_W1_d5.gestioni.Postazioni.Postazione;
import U5_W1_d5.gestioni.Utente.Utente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "prenotazioni")

public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;
    @ManyToOne
    @JoinColumn(name = "utente_username")
    private Utente utente;
    private LocalDateTime data;

    public Prenotazione(Postazione postazione, Utente utente, LocalDateTime data) {
        this.postazione = postazione;
        this.utente = utente;
        this.data = data;
    }
}
