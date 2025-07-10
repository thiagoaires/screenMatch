package br.com.thiagoas.screenmatch;

import br.com.thiagoas.screenmatch.services.ClientApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Primeiro projeto sem web");
		final ClientApi clientApi = new ClientApi();
		var json = clientApi.fetchData("http://www.omdbapi.com/?i=tt0238784&apikey=988114dd");
		System.out.println(json);
	}


}
