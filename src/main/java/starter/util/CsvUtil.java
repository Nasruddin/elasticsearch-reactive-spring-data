package starter.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import starter.model.Director;
import starter.model.Genre;
import starter.model.Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CsvUtil {

    public static final String TITLE = "original_title";
    public static final String GENRE = "genre";
    public static final String DIRECTOR = "director";
    public static final String RATINGS = "reviews_from_critics";

    public List<Movie> getMovies() {
        InputStream isstream = this.getClass().getClassLoader().getResourceAsStream("movies.csv");
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(isstream),
                StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<Movie> lMovies = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                    Movie aMovie = Movie.builder()
                            .name(csvRecord.get(TITLE))
                            .genre(List.of(Genre.builder().name(csvRecord.get(GENRE)).build()))
                            .director(Director.builder().name(csvRecord.get(DIRECTOR)).build())
                            .rating(Objects.equals(csvRecord.get(RATINGS), "") ? 1.0 : Double.parseDouble(csvRecord.get(RATINGS)) )
                            .build();
                lMovies.add(aMovie);
            }
            return lMovies.subList(0, 500);
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
