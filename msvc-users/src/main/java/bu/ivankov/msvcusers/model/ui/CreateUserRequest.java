package bu.ivankov.msvcusers.model.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author al.ivankov
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    @NotNull(message = "First Name must not be null")
    @Size(min = 2, message = "First Name must not be less than two characters")
    private String firstName;

    @NotNull(message = "Last Name must not be null")
    @Size(min = 2, message = "Last Name must not be less than two characters")
    private String lastName;

    @NotNull(message = "Last Name must not be null")
    @Size(min = 8, max = 16, message = "Last Name must not be less than two characters")
    private String password;

    @NotNull(message = "Email Name must not be null")
    @Email
    private String email;

}
