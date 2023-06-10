package by.itacademy.spring.database.repository;

import by.itacademy.spring.database.entity.Role;
import by.itacademy.spring.database.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRoleAndBirthDateBetween(Role role, LocalDate startDate, LocalDate endDate);

    List<User> findFirst4By(Sort sort);

    Slice<User> findAllByRole(Role role, Pageable pageable);
}
