package by.ivankov.msvc.users.repository;

import by.ivankov.msvc.users.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author al.ivankov@outlook.com
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
