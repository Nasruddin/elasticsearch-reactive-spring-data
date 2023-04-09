package starter.repository;

import org.apache.http.HttpHost;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import starter.ElasticsearchSpringDataApplication;

import java.io.IOException;
import java.util.Collections;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = ElasticsearchSpringDataApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public abstract class ElasticsearchBaseTest {

    private static final String IMAGE_NAME = "docker.elastic.co/elasticsearch/elasticsearch:8.5.0";

    protected static final ElasticsearchContainer database = new ElasticsearchContainer(IMAGE_NAME).withExposedPorts(9200)
            .withEnv("xpack.security.enabled", "false")
            .withEnv("xpack.security.transport.ssl.enabled", "false")
            .withEnv("xpack.security.http.ssl.enabled", "false");


    static {
        database.start();
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("elasticsearch.url", () -> Collections.singletonList("http://" + database.getHttpHostAddress()));
    }

    RestClient client = RestClient.builder(HttpHost.create(database.getHttpHostAddress()))
            .build();

    Response response;

    {
        try {
            response = client.performRequest(new Request("GET", "/_cluster/health"));
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}