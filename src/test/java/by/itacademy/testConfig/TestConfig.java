package by.itacademy.testConfig;


import by.itacademy.spring.database.entity.User;
import by.itacademy.spring.dto.CreateUserDto;
import by.itacademy.spring.mapper.UserMapper;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@TestConfiguration
public class TestConfig {

    @Bean("createUserDto")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CreateUserDto createUserDto() {
        return CreateUserDto.builder()
                .login("olegov555@mail.ru")
                .name("Oleg")
                .lastname("Olegov")
                .password("Olegov555")
                .build();
    }

}
