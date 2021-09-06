package starter.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import starter.model.Movie;
import starter.service.MovieService;

/**
 * Created by nasir on 14/11/17.
 */
@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieResource {

    private final MovieService movieService;

    @PostMapping
    public Mono<Movie> addMovie(@RequestBody Movie newMovie) {
        return movieService.addMovie(newMovie);
    }

    @DeleteMapping("/{id}")
    public Mono<String> deleteMovie(@PathVariable("id") String movieId) {
        movieService.deleteMovie(movieId);
        return Mono.just("Deleted");
    }

    @GetMapping("/{name}")
    public Flux<Movie> findMovieByName(@PathVariable("name") String movieName) {
        return movieService.getByName(movieName);
    }

    @PostMapping("/generate")
    private Flux<Movie> generateSampleData() {
        return movieService.saveAllMovies();
    }

    @GetMapping("/ratings")
    public Flux<Movie> findMovieBetweenRatings(@RequestParam("start") double startRating, @RequestParam("end") double endRating) {
        return movieService.getByRatingInterval(startRating, endRating);
    }
}
