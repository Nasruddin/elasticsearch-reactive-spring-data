package starter;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by Nasir on 12-09-2015.
 */
public interface BookRepository extends ElasticsearchRepository<Book, Long> {

    public List<Book> findByName(String name);
    public List<Book> findByRatingBetween(Double start, Double end);
}
