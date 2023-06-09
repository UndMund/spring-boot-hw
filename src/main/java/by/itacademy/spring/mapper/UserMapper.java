package by.itacademy.spring.mapper;


import by.itacademy.spring.database.entity.User;
import by.itacademy.spring.dto.CreateUserDto;
import by.itacademy.spring.dto.UserDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    User toUser(CreateUserDto userDto);
    UserDto toUserDto(User user);
}
