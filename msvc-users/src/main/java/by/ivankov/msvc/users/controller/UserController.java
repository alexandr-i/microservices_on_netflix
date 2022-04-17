package by.ivankov.msvc.users.controller;

import by.ivankov.msvc.users.mapper.UserDtoMapper;
import by.ivankov.msvc.users.model.dto.UserDto;
import by.ivankov.msvc.users.model.ui.CreateUserRequest;
import by.ivankov.msvc.users.model.ui.UserResponse;
import by.ivankov.msvc.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * @author al.ivankov@outlook.com
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserDtoMapper dtoMapper;
    private final Environment env;

    @GetMapping("/status")
    public String getStatus() {
        return "Current token expiration time is: " + env.getProperty("specific.property");
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return Collections.emptyList();
    }


    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable String userId) {
        return userService.findUserById(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@Valid @RequestBody CreateUserRequest userCreate) {
        log.info("Create User triggered: {}", userCreate);
        UserDto userDto = userService.createUser(dtoMapper.toUserDto(userCreate));
        return dtoMapper.toUserResp(userDto);
    }

}
