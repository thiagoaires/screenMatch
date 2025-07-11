package br.com.thiagoas.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodeData(
        @JsonAlias("Title") String title,
        @JsonAlias("Episode") Integer number,
        @JsonAlias("imdbRating") String review,
        @JsonAlias("Released") String releaseData
) {
}

/*
{
   "Title":"The Lorelais' First Day at Chilton",
   "Year":"2000",
   "Rated":"TV-PG",
   "Released":"12 Oct 2000",
   "Season":"1",
   "Episode":"2",
   "Runtime":"44 min",
   "Genre":"Comedy, Drama",
   "Director":"Arlene Sanford",
   "Writer":"Amy Sherman-Palladino",
   "Actors":"Lauren Graham, Alexis Bledel, Melissa McCarthy",
   "Plot":"Rory's first day at Chilton, where she has a confrontation with Paris. Emily tries to install an internet connection at Lorelai's house without asking first.",
   "Language":"English",
   "Country":"United States",
   "Awards":"N/A",
   "Poster":"https://m.media-amazon.com/images/M/MV5BYzgwMjZmN2QtMjIwMC00NmNlLTg1ODctNDcyNmRhN2UwMTY2XkEyXkFqcGc@._V1_SX300.jpg",
   "Ratings":[
      {
         "Source":"Internet Movie Database",
         "Value":"8.0/10"
      }
   ],
   "Metascore":"N/A",
   "imdbRating":"8.0",
   "imdbVotes":"1533",
   "imdbID":"tt0588209",
   "seriesID":"tt0238784",
   "Type":"episode",
   "Response":"True"
}
 */