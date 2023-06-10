package by.itacademy.integration;

import by.itacademy.annotation.IT;
import by.itacademy.spring.dto.CreateUserDto;
import by.itacademy.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.assertj.core.api.Assertions.assertThat;

@IT
@RequiredArgsConstructor
public class UserServiceIT {
    private final UserService userService;
    private CreateUserDto createUserDto;

    @BeforeEach
    void setUp(@Qualifier("createUserDto") CreateUserDto readUserDto) {
        this.createUserDto = readUserDto;
    }
    /*@Test
    void addUserTest() {
        var optionalUserDto = userService.createUser(createUserDto);
        assertThat(optionalUserDto).isPresent();
        optionalUserDto.ifPresent(userDto -> {
                assertThat(userDto.getName()).isEqualTo(createUserDto.getName());
                assertThat(userDto.getLastname()).isEqualTo(createUserDto.getLastname());
                assertThat(userDto.getLogin()).isEqualTo(createUserDto.getLogin());
        });
    }*/
}
