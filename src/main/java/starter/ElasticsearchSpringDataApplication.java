package starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import starter.model.Director;
import starter.model.Movie;
import starter.model.Genre;
import starter.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ElasticsearchSpringDataApplication implements CommandLineRunner{

    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchSpringDataApplication.class);


    @Autowired
    private MovieService movieService;

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchSpringDataApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        addMovies();

        List<Movie> dabanggNamedQuery = movieService.getByName("dabangg");
        logger.info("Content of dabangg name book {}", dabanggNamedQuery);

        List<Movie> readyMovieQuery = movieService.getByName("ready");
        logger.info("Content of dabangg name book {}", dabanggNamedQuery);

        List<Movie> byRating = movieService.getByRatingInterval(7d, 9d);
        logger.info("Content of book by rating 7 9 {}", byRating);
    }

    private void addMovies() {
        Movie movie1 = getFirstMovie();
        movieService.addMovie(movie1);

        Movie movie2 = getSecondMovie();
        movieService.addMovie(movie2);

        Movie mvoie3 = getThirdMovie();
        movieService.addMovie(mvoie3);

        Movie movie4 = getForthMovie();
        movieService.addMovie(movie4);
    }

    private Movie getFirstMovie() {
        Movie firstMovie = new Movie();
        firstMovie.setId(1l);
        firstMovie.setRating(8.4d);
        firstMovie.setName("Batman v Superman: Dawn of Justice");

        Director director = new Director("Zack Snyder");
        firstMovie.setDirector(director);

        List<Genre> genres = new ArrayList<Genre>();
        genres.add(new Genre("DRAMA"));
        genres.add(new Genre("ACTION"));


        firstMovie.setGenre(genres);

        return firstMovie;
    }

    private Movie getSecondMovie() {
        Movie secondMovie = new Movie();
        secondMovie.setId(2l);
        secondMovie.setRating(9.4d);
        secondMovie.setName("The Dark Knight Rises");

        Director director = new Director("Christopher Nolan");
        secondMovie.setDirector(director);

        List<Genre> genres = new ArrayList<Genre>();
        genres.add(new Genre("ROMANTIC"));
        genres.add(new Genre("ACTION"));

        secondMovie.setGenre(genres);

        return secondMovie;
    }

    private Movie getThirdMovie() {
        Movie thirdMovie = new Movie();
        thirdMovie.setId(3l);
        thirdMovie.setRating(8d);
        thirdMovie.setName("Batman Begins");

        Director director = new Director("Christopher Nolan");
        thirdMovie.setDirector(director);

        List<Genre> genres = new ArrayList<Genre>();
        genres.add(new Genre("ROMANTIC"));
        genres.add(new Genre("ACTION"));

        thirdMovie.setGenre(genres);

        return thirdMovie;
    }

    private Movie getForthMovie() {
        Movie forthMovie = new Movie();
        forthMovie.setId(4l);
        forthMovie.setRating(8d);
        forthMovie.setName("Batman & Robin");

        Director director = new Director("Joel Schumacher");
        forthMovie.setDirector(director);

        List<Genre> genres = new ArrayList<Genre>();
        genres.add(new Genre("ROMANTIC"));
        genres.add(new Genre("ACTION"));

        forthMovie.setGenre(genres);

        return forthMovie;
    }
}
