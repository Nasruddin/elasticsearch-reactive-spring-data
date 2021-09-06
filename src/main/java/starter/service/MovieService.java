package starter.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import starter.model.Director;
import starter.model.Genre;
import starter.repository.MovieRepository;
import starter.model.Movie;
import starter.util.CsvUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nasir on 12-09-2015.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {

    private final MovieRepository movieRepository;
    private final CsvUtil csvUtil;

    public Flux<Movie> getByName(String name) {
        return movieRepository.findByName(name);
    }

    public Flux<Movie> getByRatingInterval(Double start, Double end) {
        return movieRepository.findByRatingBetween(start, end);
    }

    public Mono<Movie> addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }

    public Flux<Movie> findByDirector(Director director) {
        return movieRepository.findByDirector(director);
    }

    public Flux<Movie> saveAllMovies() {
        return movieRepository.saveAll(csvUtil.getMovies()).doOnNext(movie -> log.info("Added: " + movie));
    }

}
