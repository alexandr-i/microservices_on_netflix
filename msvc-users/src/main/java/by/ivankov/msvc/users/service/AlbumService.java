package by.ivankov.msvc.users.service;

import by.ivankov.msvc.users.model.dto.AlbumDto;

import java.util.List;

/**
 * @author al.ivankov@outlook.com
 */
public interface AlbumService {

    List<AlbumDto> getAlbumsByUserId(String userId);
}
