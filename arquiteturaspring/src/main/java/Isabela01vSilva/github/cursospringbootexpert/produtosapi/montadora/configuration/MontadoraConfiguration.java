package Isabela01vSilva.github.cursospringbootexpert.produtosapi.montadora.configuration;

import isabela01vsilva.arquiteturaspring.montadora.Motor;
import isabela01vsilva.arquiteturaspring.montadora.TipoMotor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class MontadoraConfiguration {

    @Bean(name = "motorAspirado")
    @Scope("singleton")
    public Motor motorAspirado(@Value("${app.montadora.motor-padrao}")Integer cavalos) {
        var motor = new Motor();
        motor.setCavalos(cavalos);
        motor.setCilindros(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return  motor;
    }

    @Bean(name = "motorEletrico")
    public Motor motorEletrico() {
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindros(3);
        motor.setModelo("TH-4");
        motor.setLitragem(1.4);
        motor.setTipo(TipoMotor.ELETRICO);
        return  motor;
    }

    @Primary
    @Bean(name = "motorTurbo")
    public Motor motorTurbo() {
        var motor = new Motor();
        motor.setCavalos(180);
        motor.setCilindros(4);
        motor.setModelo("XPTO-01");
        motor.setLitragem(1.5);
        motor.setTipo(TipoMotor.TURBO);
        return  motor;
    }
}