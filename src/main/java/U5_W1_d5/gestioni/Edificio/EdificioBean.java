package U5_W1_d5.gestioni.Edificio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class EdificioBean {
    @Bean(name = "Edificio1")
    public Edificio getEdificio() {
        return new Edificio("Epicode", "Via Roma, 13 - 20159 Roma", "Roma");
    }

    @Bean(name = "Edificio2")
    public Edificio getEdificio2() {
        return new Edificio("Epicode", "Via dante, 46 , 20135, Milano", "Milano");
    }
}