package bu.ivankov.msvcusers.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author al.ivankov
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    public static final long serialVersionUID = -684621984168549684L;

    private Long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
