package U5_W1_d5.gestioni.Utente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteSRV {

    @Autowired
    UtenteRepo utenteRepo;

    public void save(Utente user) {
        if (utenteRepo.findByUsername(user.getUsername()).isEmpty()) {
            utenteRepo.save(user);
        } else {
            throw new IllegalArgumentException(user.getUsername());
        }
    }

    public Utente findByUsername(String username){
        return utenteRepo.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("Utente not found"));
    }
}