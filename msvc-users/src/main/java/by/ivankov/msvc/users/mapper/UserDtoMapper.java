package by.ivankov.msvc.users.mapper;

import by.ivankov.msvc.users.model.ui.UserResponse;
import by.ivankov.msvc.users.model.dto.UserDto;
import by.ivankov.msvc.users.model.ui.CreateUserRequest;
import org.mapstruct.Mapper;

/**
 * @author al.ivankov@outlook.com
 */
@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    UserDto toUserDto(CreateUserRequest req);
    UserResponse toUserResp(UserDto dto);

}
