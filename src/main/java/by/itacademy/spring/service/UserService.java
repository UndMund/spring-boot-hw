package by.itacademy.spring.service;

import by.itacademy.spring.database.repository.UserRepository;
import by.itacademy.spring.dto.CreateUserDto;
import by.itacademy.spring.dto.UserDto;
import by.itacademy.spring.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Validated
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public Optional<UserDto> createUser(@Valid CreateUserDto userDto) {
        return userRepository.createUser(userMapper.toUser(userDto))
                .map(userMapper::toUserDto);
    }
}
