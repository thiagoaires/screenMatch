package br.com.thiagoas.screenmatch;

import br.com.thiagoas.screenmatch.model.EpisodeData;
import br.com.thiagoas.screenmatch.model.SerieData;
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
//		System.out.println("Primeiro projeto sem web");
		final ClientApi clientApi = new ClientApi();
		var json = clientApi.fetchData("http://www.omdbapi.com/?i=tt0238784&apikey=988114dd");

		System.out.println(json);
		ConvertData conversor = new ConvertData();
		var serieData = conversor.getData(json, SerieData.class);
		System.out.println(serieData);

		var episodeJson = clientApi.fetchData("https://www.omdbapi.com/?i=tt0238784&season=1&episode=2&apikey=988114dd");
		var episodeData = conversor.getData(episodeJson, EpisodeData.class);
		System.out.println(episodeData);

		var listEpisodes = new ArrayList<EpisodeData>();
		for(int i = 1; i <= serieData.totalTemporadas(); i++){

			var url = "https://www.omdbapi.com/?i=tt0238784&season=1&episode=" + i + "&apikey=988114dd";
			var seasonJson = clientApi.fetchData(url);
			var epData = conversor.getData(seasonJson, EpisodeData.class);
			listEpisodes.add(epData);
		}
		System.out.println("==========");
		listEpisodes.forEach(System.out::println);

	}


}
