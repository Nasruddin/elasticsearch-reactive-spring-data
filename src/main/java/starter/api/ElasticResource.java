package starter.api;

import lombok.RequiredArgsConstructor;

import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import starter.model.Movie;


/**
 * Created by nasir on 14/11/17.
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/elastic-cluster")
public class ElasticResource {

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
