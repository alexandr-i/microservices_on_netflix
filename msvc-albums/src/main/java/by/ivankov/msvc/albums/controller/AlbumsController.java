package by.ivankov.msvc.albums.controller;

import by.ivankov.msvc.albums.data.AlbumEntity;
import by.ivankov.msvc.albums.mapper.AlbumMapper;
import by.ivankov.msvc.albums.service.AlbumService;
import by.ivankov.msvc.albums.dto.AlbumDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users/{id}/albums")
public class AlbumsController {

    private final AlbumService albumsService;
    private final AlbumMapper albumMapper;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,})
    public List<AlbumDto> userAlbums(@PathVariable String id) {

        List<AlbumEntity> albumsEntities = albumsService.getAlbums(id);

        if (albumsEntities == null || albumsEntities.isEmpty()) {
            return Collections.emptyList();
        }

        List<AlbumDto> albumResponseModels = albumMapper.toAlbumList(albumsEntities);
        log.info("Returning " + albumResponseModels.size() + " albums");
        return albumResponseModels;
    }
}
