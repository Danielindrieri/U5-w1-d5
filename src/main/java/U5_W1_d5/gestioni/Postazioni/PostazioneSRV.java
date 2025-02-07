package U5_W1_d5.gestioni.Postazioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneSRV {

    @Autowired
    PostazioneRepo postazioneRepo;

    public void save(Postazione postazione){
        postazioneRepo.save(postazione);
    }

    public List<Postazione> FindAllElement(){
        return  postazioneRepo.findAll();
    }

    public void findByIdAndUpdate(long Id, Postazione postazione) {
        Postazione found = this.findById(Id);
        found.setTipo(postazione.getTipo());
        found.setDescrizione(postazione.getDescrizione());
        found.setEdificio(postazione.getEdificio());
        found.setNumeroMassimoOccupanti(postazione.getNumeroMassimoOccupanti());
        postazioneRepo.save(found);
    }

    public void findByIdAndUpdateTru(long Id, Postazione postazione) {
        Postazione found = this.findById(Id);
        found.setTipo(postazione.getTipo());
        found.setDescrizione(postazione.getDescrizione());
        found.setEdificio(postazione.getEdificio());
        found.setNumeroMassimoOccupanti(postazione.getNumeroMassimoOccupanti());
        postazioneRepo.save(found);
    }

    public Postazione findById(long id){
        return postazioneRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Postazione not found"));
    }

    public List<Postazione> findPostazioni(long id){
        return postazioneRepo.findByEdificioId(id);
    }
}