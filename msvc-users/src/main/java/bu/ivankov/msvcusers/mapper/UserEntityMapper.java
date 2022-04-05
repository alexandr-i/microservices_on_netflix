package bu.ivankov.msvcusers.mapper;

import bu.ivankov.msvcusers.model.dto.UserDto;
import bu.ivankov.msvcusers.model.entity.UserEntity;
import org.mapstruct.Mapper;

/**
 * @author al.ivankov
 */
@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntity toUserEntity(UserDto dto);
    UserDto toUserDto(UserEntity entity);

}
