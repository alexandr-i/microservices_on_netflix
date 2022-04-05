package bu.ivankov.msvcusers.controller;

import bu.ivankov.msvcusers.mapper.UserDtoMapper;
import bu.ivankov.msvcusers.model.dto.UserDto;
import bu.ivankov.msvcusers.model.ui.CreateUserRequest;
import bu.ivankov.msvcusers.model.ui.UserResponse;
import bu.ivankov.msvcusers.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * @author al.ivankov
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserDtoMapper dtoMapper;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return Collections.emptyList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@Valid @RequestBody CreateUserRequest userCreate) {
        log.info("Create User triggered: {}", userCreate);
        UserDto userDto = userService.createUser(dtoMapper.toUserDto(userCreate));
        return dtoMapper.toUserResp(userDto);
    }

}
