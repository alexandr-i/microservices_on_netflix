package by.ivankov.msvc.users.service.impl;

import by.ivankov.msvc.users.model.dto.AlbumDto;
import by.ivankov.msvc.users.service.AlbumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author al.ivankov@outlook.com
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class RestTemplateAlbumService implements AlbumService {

    private final RestTemplate restTemplate;
    private final Environment env;

    @Override
    public List<AlbumDto> getAlbumsByUserId(String userId) {
        String albumUrl = String.format(env.getProperty("msvc.albums.url"), userId);

        ResponseEntity<List<AlbumDto>> response = restTemplate.exchange(albumUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<AlbumDto>>() {
        });
        log.info("Album call for {}. Result: {}", userId, response);
        return response.getBody();
    }


}
