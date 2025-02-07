package U5_W1_d5.gestioni.Prenotazioni;

import U5_W1_d5.gestioni.Postazioni.Postazione;
import U5_W1_d5.gestioni.Utente.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneSRV {

    @Autowired
    PrenotazioneRepo prenotazioneRepo;

    public void save(Prenotazione prenotazione){
        prenotazioneRepo.save(prenotazione);

    }

    public List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data){
        return prenotazioneRepo.findByUtenteAndData(utente, data);
    }

    public List<Prenotazione> findByPostazione(Postazione postazione, LocalDate data){
        return prenotazioneRepo.findByPostazioneAndData(postazione, data);
    }

    public List<Prenotazione> findByData(LocalDate data){
        return prenotazioneRepo.findByData(data);
    }

    public List<Prenotazione> findByUtente(Utente utente){
        return prenotazioneRepo.findByUtente(utente);
    }
}