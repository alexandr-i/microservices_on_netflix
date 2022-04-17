package by.ivankov.msvc.albums.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author al.ivankov@outlook.com
 */
@Getter
@Setter
public class AlbumDto {
    private String albumId;
    private String userId;
    private String name;
    private String description;

}
