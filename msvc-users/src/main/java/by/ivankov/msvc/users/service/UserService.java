package by.ivankov.msvc.users.service;

import by.ivankov.msvc.users.model.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author al.ivankov@outlook.com
 */
public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);
    UserDto findUserByEmail(String email);
    UserDto findUserById(String userId);
}
