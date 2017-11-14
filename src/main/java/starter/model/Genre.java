package starter.model;

import lombok.*;

/**
 * Created by Nasir on 12-09-2015.
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Genre {

    @NonNull
    private String name;
}
