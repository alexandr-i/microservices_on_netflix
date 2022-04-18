package by.ivankov.msvc.users.client;

import by.ivankov.msvc.users.model.dto.AlbumDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

/**
 * @author al.ivankov@outlook.com
 */
@FeignClient(name = "msvc-albums")
public interface AlbumClient {

    @Retry(name = "msvc-albums")
    @CircuitBreaker(name = "msvc-albums", fallbackMethod = "getAlbumsFallback")
    @GetMapping("/users/{userId}/albums")
    List<AlbumDto> getAlbumsByUserId(@PathVariable String userId);

    default List<AlbumDto> getAlbumsFallback(String userId, Throwable exc) {
        return Collections.emptyList();
    }
}
