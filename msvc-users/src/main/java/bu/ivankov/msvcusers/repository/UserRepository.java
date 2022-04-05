package bu.ivankov.msvcusers.repository;

import bu.ivankov.msvcusers.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author al.ivankov
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
