package starter.api;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import starter.model.Movie;

import java.util.List;
import java.util.Map;

/**
 * Created by nasir on 14/11/17.
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/elastic-cluster")
public class ElasticResource {

    private final ElasticsearchRestTemplate elasticsearchTemplate;
    private final ReactiveElasticsearchTemplate reactiveElasticsearchTemplate;
    private final ReactiveElasticsearchOperations reactiveElasticsearchOperations;

    @GetMapping("/info")
    public Flux<IndexInformation> getClusterInfo() {
        return reactiveElasticsearchTemplate.indexOps(Movie.class).getInformation();
    }

    @DeleteMapping("/clear-indices")
    public Mono<String> clearIndices() {
        return reactiveElasticsearchOperations.indexOps(Movie.class).delete().flatMap(this::getDeleted);
    }

    private Mono<String> getDeleted(Boolean isDeleted) {
        if (isDeleted) {
            return Mono.just("Deleted");
        } else {
            return Mono.just("Unable to delete");
        }
    }
}
