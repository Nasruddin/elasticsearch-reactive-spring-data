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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "movie-store")
public class Movie {

    @Id
    private String id;

    private String name;

    @Field(type = FieldType.Nested)
    private List<Genre> genre;

    private Double rating;

    @Field(type = FieldType.Object)
    private Director director;

}
