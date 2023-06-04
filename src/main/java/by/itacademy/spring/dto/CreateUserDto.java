package by.itacademy.spring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
    @Size(min = 2, max = 20, message = "Name must be 2-10 characters long")
    String name;
    @Size(min = 2, max = 20, message = "Lastname must be 2-10 characters long")
    String lastname;
    @Email(message = "Email must be real")
    String login;
    @Size(min = 6, message = "Password must contain at least 6 characters")
    String password;

}
