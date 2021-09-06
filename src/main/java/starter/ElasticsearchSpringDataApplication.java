package starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import reactor.core.publisher.Flux;
import starter.model.Director;
import starter.model.Movie;
import starter.model.Genre;
import starter.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ElasticsearchSpringDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchSpringDataApplication.class, args);
    }
}
