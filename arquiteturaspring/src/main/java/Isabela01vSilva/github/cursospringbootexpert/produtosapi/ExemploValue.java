package Isabela01vSilva.github.cursospringbootexpert.produtosapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExemploValue {

    @Value("${app.config.variavel}")
    private String variavel;

    public void imprimirVariavel(){
        System.out.println(variavel);
    }
}
