package by.itacademy.integration.repository;

import by.itacademy.TestApplicationRunner;
import by.itacademy.spring.ApplicationRunner;
import by.itacademy.spring.database.entity.Role;
import by.itacademy.spring.database.entity.User;
import by.itacademy.spring.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
@AutoConfigureTestDatabase
@SpringBootTest(classes = {TestApplicationRunner.class, ApplicationRunner.class})
@Transactional
public class UserRepositoryTest {
    private final UserRepository userRep;
    private static final Role ADMIN_ROLE = Role.ADMIN;
    private static final Role USER_ROLE = Role.USER;

    @Test
    public void findByRoleAndBirthDateBetweenTest() {
        LocalDate startDate = LocalDate.of(1983, 1, 1);
        LocalDate endDate = LocalDate.of(1991, 1, 1);

        var actualResult = userRep.findByRoleAndBirthDateBetween(ADMIN_ROLE, startDate, endDate);
        assertThat(actualResult).hasSize(2);
        actualResult.forEach(user ->
            assertEquals(ADMIN_ROLE, user.getRole())
        );
    }

    @Test
    public void findFirst4ByBirthDateTest() {
        var users = userRep.findFirst4By(
                Sort.by("birthDate"));
        assertFalse(users.isEmpty());
        assertThat(users).hasSize(4);
    }

    @Test
    public void findFirst4ByBirthDateAndFioTest() {
        var users = userRep.findFirst4By(
                Sort.by("birthDate")
                        .and(Sort.by("firstname")
                                .and(Sort.by("lastname"))));
        assertFalse(users.isEmpty());
        assertThat(users).hasSize(4);
    }

    @Test
    void checkPageableRoleFilterTest() {
        Pageable pageable = PageRequest.of(0, 5);
        Slice<User> slice = userRep.findAllByRole(USER_ROLE, pageable);
        assertFalse(slice.isEmpty());
        assertThat(slice).hasSize(3);
    }

    @Test
    void checkPageableDynamicSortTest() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("birthDate"));
        Slice<User> slice = userRep.findAllByRole(USER_ROLE, pageable);
    }

    @Test
    void checkPageable() {
        Pageable pageable0 = PageRequest.of(0, 2);

        Slice<User> slice = userRep.findAllByRole(USER_ROLE, pageable0);
        assertThat(slice).hasSize(2);
        assertTrue(slice.hasNext());

        slice = userRep.findAllByRole(USER_ROLE, slice.nextPageable());

        assertThat(slice).hasSize(1);
        assertFalse(slice.hasNext());
    }
}
