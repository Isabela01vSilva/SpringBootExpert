package Isabela01vSilva.github.cursospringbootexpert.produtosapi;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties
public class ProdutosApiApplication {
	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);

		SpringApplicationBuilder builder = new SpringApplicationBuilder(ProdutosApiApplication.class);

		builder.bannerMode(Banner.Mode.OFF);
		builder.profiles("producao", "homologacao");
		//builder.lazyInitialization(true);

		builder.run(args);

		//Contexto da aplicação já iniciada:
		ConfigurableApplicationContext applicationContext = builder.context();
		//var produtoRepository = applicationContext.getBean("produtoRepository");

		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String applicationName = environment.getProperty("spring.application.name");
		System.out.println("Nome da aplicação: " + applicationName);


		ExemploValue value = applicationContext.getBean(ExemploValue.class);
		value.imprimirVariavel();

	}
}
