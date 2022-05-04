package application.politicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


@EnableSpringDataWebSupport @SpringBootApplication
public class PoliticosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoliticosApplication.class, args);
	}

}
