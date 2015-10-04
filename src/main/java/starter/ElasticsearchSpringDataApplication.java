package starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ElasticsearchSpringDataApplication implements CommandLineRunner{

    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchSpringDataApplication.class);

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchSpringDataApplication.class, args);
    }

    private void addBooks() {
        Book dabangg = getFirstMovie();
        bookService.addMovie(dabangg);

        Book dabangg2 = getSecondMovie();
        bookService.addMovie(dabangg2);
    }

    private Book getFirstMovie() {
        Book firstBook = new Book();
        firstBook.setId("1");
        firstBook.setRating(8.4d);
        firstBook.setName("Dabangg");

        List<Genre> dabanggGenre = new ArrayList<Genre>();
        dabanggGenre.add(new Genre("DRAMA"));
        dabanggGenre.add(new Genre("ACTION"));

        firstBook.setGenre(dabanggGenre);

        return firstBook;
    }

    private Book getSecondMovie() {
        Book secondBook = new Book();
        secondBook.setId("2");
        secondBook.setRating(9.4d);
        secondBook.setName("Dabangg 555");

        List<Genre> dabangg2Genre = new ArrayList<Genre>();
        dabangg2Genre.add(new Genre("ROMANTIC"));
        dabangg2Genre.add(new Genre("ACTION"));

        secondBook.setGenre(dabangg2Genre);

        return secondBook;
    }

    @Override
    public void run(String... strings) throws Exception {
        addBooks();

        List<Book> dabanggNamedQuery = bookService.getByName("dabangg");
        logger.info("Content of dabangg name book {}", dabanggNamedQuery);

        List<Book> readyBookQuery = bookService.getByName("ready");
        logger.info("Content of dabangg name book {}", dabanggNamedQuery);

        List<Book> byRating = bookService.getByRatingInterval(7d, 9d);
        logger.info("Content of book by rating 7 9 {}", byRating);
    }
}
