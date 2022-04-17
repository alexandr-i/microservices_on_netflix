package by.ivankov.msvc.albums.mapper;

import by.ivankov.msvc.albums.data.AlbumEntity;
import by.ivankov.msvc.albums.dto.AlbumDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author al.ivankov@outlook.com
 */
@Mapper(componentModel = "spring")
public interface AlbumMapper {

    List<AlbumDto> toAlbumList(List<AlbumEntity> entities);

}
