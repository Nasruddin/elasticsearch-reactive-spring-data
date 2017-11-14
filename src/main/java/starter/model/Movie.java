package starter.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * Created by Nasir on 12-09-2015.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "movie-store", type = "movie", shards = 1, replicas = 0)
public class Movie {

    @Id
    private Long id;

    private String name;

    @Field(type = FieldType.Nested)
    private List<Genre> genre;

    private Double rating;

    @Field(type = FieldType.Nested)
    private Director director;

}
