package starter.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import starter.model.Director;
import starter.model.Movie;

import java.util.List;

/**
 * Created by Nasir on 12-09-2015.
 */
@Repository
public interface MovieRepository extends ElasticsearchRepository<Movie, Long> {

    List<Movie> findByName(String name);
    List<Movie> findByRatingBetween(Double start, Double end);
    List<Movie> findByDirector(Director director);
}
