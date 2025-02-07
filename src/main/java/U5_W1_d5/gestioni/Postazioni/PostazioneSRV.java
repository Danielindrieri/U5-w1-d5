package U5_W1_d5.gestioni.Postazioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneSRV {

    @Autowired
    PostazioneDAO postazioneDAO;

    public void save(Postazione postazione){
        postazioneDAO.save(postazione);
    }

    public List<Postazione> FindAllElement(){
        return  postazioneDAO.findAll();
    }

    public void findByIdAndUpdate(long Id, Postazione postazione) {
        Postazione found = this.findById(Id);
        found.setTipo(postazione.getTipo());
        found.setDescrizione(postazione.getDescrizione());
        found.setEdificio(postazione.getEdificio());
        found.setNumeroMassimoOccupanti(postazione.getNumeroMassimoOccupanti());
        postazioneDAO.save(found);
    }

    public void findByIdAndUpdateTru(long Id, Postazione postazione) {
        Postazione found = this.findById(Id);
        found.setTipo(postazione.getTipo());
        found.setDescrizione(postazione.getDescrizione());
        found.setEdificio(postazione.getEdificio());
        found.setNumeroMassimoOccupanti(postazione.getNumeroMassimoOccupanti());
        postazioneDAO.save(found);
    }

    public Postazione findById(long id){
        return postazioneDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("Postazione not found"));
    }

    public List<Postazione> findPostazioni(long id){
        return postazioneDAO.findByEdificioId(id);
    }
}