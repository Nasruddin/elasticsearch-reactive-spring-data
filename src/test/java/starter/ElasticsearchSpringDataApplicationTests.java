package starter;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import starter.model.Director;
import starter.model.Movie;
import starter.service.MovieService;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticsearchSpringDataApplication.class)
public class ElasticsearchSpringDataApplicationTests {


    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Before
    public void before() {
        elasticsearchTemplate.deleteIndex(Movie.class);
        elasticsearchTemplate.createIndex(Movie.class);
        elasticsearchTemplate.putMapping(Movie.class);
        elasticsearchTemplate.refresh(Movie.class);

    }

}
