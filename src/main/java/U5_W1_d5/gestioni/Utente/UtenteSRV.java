package U5_W1_d5.gestioni.Utente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.hibernate.query.sqm.tree.SqmNode.log;

@Service
public class UtenteSRV {

    @Autowired
    UtenteDAO utenteDAO;

    public void save(Utente user) {
        if (utenteDAO.findByUsername(user.getUsername()).isEmpty()) {
            utenteDAO.save(user);
        } else {
            throw new IllegalArgumentException(user.getUsername());
        }
    }

    public Utente findByUsername(String username){
        return utenteDAO.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("Utente not found"));
    }
}