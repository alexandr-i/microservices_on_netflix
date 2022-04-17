package by.ivankov.msvc.users.client;

import by.ivankov.msvc.users.model.dto.AlbumDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author al.ivankov@outlook.com
 */
@FeignClient(name = "msvc-albums")
public interface AlbumClient {

    @GetMapping("/users/{userId}/albums")
    List<AlbumDto> getAlbumsByUserId(@PathVariable String userId);
}
