package by.ivankov.msvc.users.service.impl;

import by.ivankov.msvc.users.client.AlbumClient;
import by.ivankov.msvc.users.model.dto.AlbumDto;
import by.ivankov.msvc.users.service.AlbumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author al.ivankov@outlook.com
 */
@Slf4j
@RequiredArgsConstructor
@Service
@Primary
public class FeignClientServiceImpl implements AlbumService {

    private final AlbumClient albumClient;

    @Override
    public List<AlbumDto> getAlbumsByUserId(String userId) {
        List<AlbumDto> albumsByUserId = albumClient.getAlbumsByUserId(userId);
        log.info("Feign call: {}", albumsByUserId);
        return albumsByUserId;
    }
}
