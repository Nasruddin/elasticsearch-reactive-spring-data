package starter.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import starter.model.Director;
import starter.model.Movie;

import java.util.List;

/**
 * Created by Nasir on 12-09-2015.
 */
@Repository
public interface MovieRepository extends ReactiveCrudRepository<Movie, String> {
    Flux <Movie> findByName(String name);
    Flux<Movie> findByRatingBetween(Double start, Double end);
    Flux<Movie> findByDirector(Director director);
}
