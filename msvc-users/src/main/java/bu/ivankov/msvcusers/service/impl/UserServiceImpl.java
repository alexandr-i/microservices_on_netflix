package bu.ivankov.msvcusers.service.impl;

import bu.ivankov.msvcusers.mapper.UserEntityMapper;
import bu.ivankov.msvcusers.model.dto.UserDto;
import bu.ivankov.msvcusers.model.entity.UserEntity;
import bu.ivankov.msvcusers.repository.UserRepository;
import bu.ivankov.msvcusers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

/**
 * @author al.ivankov
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserEntityMapper mapper;
    private final BCryptPasswordEncoder encoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        UserEntity entity = mapper.toUserEntity(userDto);
        entity.setEncryptedPassword(encoder.encode(userDto.getPassword()));
        entity = userRepository.save(entity);

        return mapper.toUserDto(entity);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return userRepository.findByEmail(email).map(mapper::toUserDto)
                .orElseThrow(() -> new UsernameNotFoundException("Unknown user login :" + email));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Unknown user login :" + email));
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true,
                true, true, true, Collections.emptyList());
    }
}
