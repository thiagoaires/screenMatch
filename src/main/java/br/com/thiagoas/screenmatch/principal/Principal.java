package br.com.thiagoas.screenmatch.principal;

import br.com.thiagoas.screenmatch.model.EpisodeData;
import br.com.thiagoas.screenmatch.model.SeasonData;
import br.com.thiagoas.screenmatch.model.SerieData;
import br.com.thiagoas.screenmatch.services.ClientApi;
import br.com.thiagoas.screenmatch.services.ConvertData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private final Scanner reader = new Scanner(System.in);
    private final String URL = "https://www.omdbapi.com/";
    private final String APIKEY = "?apikey=988114dd";
    private final ClientApi client = new ClientApi();
    private final ConvertData conversor = new ConvertData();
    public void showMenu(){
        System.out.println("Digite o nome da série para efetuar uma busca:");
        var serieName = reader.nextLine();
        var url = URL + APIKEY + "&t=" + serieName.replace(" ", "+");
        var response = client.fetchData(url);
        var serieData = conversor.getData(response, SerieData.class);
        System.out.println(serieData);


        var seasonsData = new ArrayList<SeasonData>();
        for(int i = 1; i <= serieData.totalTemporadas(); i++){
            final String urlEpisode = URL + APIKEY + "&t=" + serieName.replace(" ", "+") + "&season=" + i ;
            var seasonJson = client.fetchData(urlEpisode);
            var seasonData = conversor.getData(seasonJson, SeasonData.class);
            seasonsData.add(seasonData);
        }
        seasonsData.forEach(System.out::println);

//        for (int i = 0; i < serieData.totalTemporadas(); i++) {
//            List<EpisodeData> episodesData = seasonsData.get(i).episodes();
//            for (EpisodeData episodeData : episodesData) {
//                System.out.println(episodeData.title());
//            }
//
//        }
        seasonsData.forEach(s -> s.episodes().forEach(e -> System.out.println(e.title())));
    }
}

//  var url = "https://www.omdbapi.com/?i=tt0238784&season=1&episode=" + i + "&apikey=988114dd";