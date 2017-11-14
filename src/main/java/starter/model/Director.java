package starter.model;

import lombok.*;

import java.util.List;

/**
 * Created by nasir on 14/11/17.
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Director {

    @NonNull
    private String name;

    private List<Movie> movies;
}
