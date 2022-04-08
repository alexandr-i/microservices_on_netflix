package by.ivankov.msvc.users.mapper;

import by.ivankov.msvc.users.model.dto.UserDto;
import by.ivankov.msvc.users.model.entity.UserEntity;
import org.mapstruct.Mapper;

/**
 * @author al.ivankov@outlook.com
 */
@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntity toUserEntity(UserDto dto);
    UserDto toUserDto(UserEntity entity);

}
