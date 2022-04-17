package by.ivankov.msvc.albums.data;

import lombok.Getter;
import lombok.Setter;

/**
 * @author al.ivankov@outlook.com
 */
@Setter
@Getter
public class AlbumEntity {
    private Long id;
    private String albumId;
    private String userId;
    private String name;
    private String description;

}
