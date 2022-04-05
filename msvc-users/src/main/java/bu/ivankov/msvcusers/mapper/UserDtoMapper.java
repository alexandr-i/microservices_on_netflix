package bu.ivankov.msvcusers.mapper;

import bu.ivankov.msvcusers.model.dto.UserDto;
import bu.ivankov.msvcusers.model.ui.CreateUserRequest;
import bu.ivankov.msvcusers.model.ui.UserResponse;
import org.mapstruct.Mapper;

/**
 * @author al.ivankov
 */
@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    UserDto toUserDto(CreateUserRequest req);
    UserResponse toUserResp(UserDto dto);

}
