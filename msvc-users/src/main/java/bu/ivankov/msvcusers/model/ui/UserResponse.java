package bu.ivankov.msvcusers.model.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author al.ivankov
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String userId;

}
