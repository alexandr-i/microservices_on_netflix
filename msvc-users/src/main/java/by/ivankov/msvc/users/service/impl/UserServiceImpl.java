package by.ivankov.msvc.users.service.impl;

import by.ivankov.msvc.users.mapper.UserEntityMapper;
import by.ivankov.msvc.users.model.dto.AlbumDto;
import by.ivankov.msvc.users.model.dto.UserDto;
import by.ivankov.msvc.users.model.entity.UserEntity;
import by.ivankov.msvc.users.repository.UserRepository;
import by.ivankov.msvc.users.service.AlbumService;
import by.ivankov.msvc.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @author al.ivankov@outlook.com
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AlbumService albumService;
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
    public UserDto findUserByEmail(String email) {
        return userRepository.findByEmail(email).map(mapper::toUserDto)
                .orElseThrow(() -> new UsernameNotFoundException("Unknown user email :" + email));
    }

    @Override
    public UserDto findUserById(String userId) {
        UserDto userDto = userRepository.findByUserId(userId).map(mapper::toUserDto)
                .orElseThrow(() -> new UsernameNotFoundException("Unknown user id :" + userId));
        log.info("findUserById -> Before albumService.getAlbumsByUserId");
        List<AlbumDto> albums = albumService.getAlbumsByUserId(userId);
        userDto.setAlbumList(albums);
        return userDto;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Unknown user login :" + email));
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true,
                true, true, true, Collections.emptyList());
    }
}
