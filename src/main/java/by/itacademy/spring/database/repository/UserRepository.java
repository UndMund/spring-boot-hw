package by.itacademy.spring.database.repository;

import by.itacademy.spring.database.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    public Optional<User> createUser(User user) {
        return Optional.ofNullable(user);
    }
}
