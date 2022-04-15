package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@AllArgsConstructor
@Getter
public class UserDetail {

    private final Long id;
    private final String name;
    private final String grade;
    private final String school_name;
    private final String city;
}
