package starter.repository;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

public class RepoTest extends ElasticsearchBaseTest {

    @Autowired
    private MovieRepository repository;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void dummyTest()  {
        repository.deleteAll().subscribe(System.out::println);
    }
}
