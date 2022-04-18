package by.ivankov.msvc.users.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author al.ivankov@outlook.com
 */
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {

        //My custom exception creating based on some data

        return switch (response.status()) {
            case 400 -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Smth wrong on my side :))))");
            case 404 -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Smth wrong on my side2 :))))");
            default -> new Exception(response.toString());
        };

    }
}
