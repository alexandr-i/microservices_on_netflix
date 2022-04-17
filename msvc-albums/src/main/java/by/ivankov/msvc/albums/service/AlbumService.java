package by.ivankov.msvc.albums.service;


import by.ivankov.msvc.albums.data.AlbumEntity;

import java.util.List;

/**
 * @author al.ivankov@outlook.com
 */
public interface AlbumService {
    List<AlbumEntity> getAlbums(String userId);
}
