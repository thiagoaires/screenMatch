package br.com.thiagoas.screenmatch;

import br.com.thiagoas.screenmatch.model.EpisodeData;
import br.com.thiagoas.screenmatch.model.SerieData;
import br.com.thiagoas.screenmatch.principal.Principal;
import br.com.thiagoas.screenmatch.services.ClientApi;
import br.com.thiagoas.screenmatch.services.ConvertData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;


@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.showMenu();

	}


}
