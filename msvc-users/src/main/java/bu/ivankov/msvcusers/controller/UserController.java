package bu.ivankov.msvcusers.controller;

import bu.ivankov.msvcusers.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author al.ivankov
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<UserDto> getAllUsers() {
        return Collections.emptyList();
    }
}
