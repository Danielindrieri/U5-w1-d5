package U5_W1_d5.gestioni.Edificio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioSRV {

    @Autowired
    EdificioDAO edificioDAO;

    public void save(Edificio edificio){
        edificioDAO.save(edificio);
    }

    public List<Edificio> findByCitta(String citta){
        return edificioDAO.findByCittaIgnoreCase(citta);
    }
}