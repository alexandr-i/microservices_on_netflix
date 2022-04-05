package bu.ivankov.msvcusers.service;

import bu.ivankov.msvcusers.model.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author al.ivankov
 */
public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);
    UserDto getUserByEmail(String email);
}
