package by.itacademy.integration.repository;

import by.itacademy.TestApplicationRunner;
import by.itacademy.spring.ApplicationRunner;
import by.itacademy.spring.database.entity.Company;
import by.itacademy.spring.database.entity.Role;
import by.itacademy.spring.database.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;
import java.util.function.IntToDoubleFunction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
@AutoConfigureTestDatabase
@SpringBootTest(classes = {TestApplicationRunner.class, ApplicationRunner.class})
@Transactional
public class CompanyRepositoryTest {
    private final CompanyRepository companyRep;
    @Test
    void updateCompanyByIdTest() {
        String name = "Opera";
        Integer id = 1;

        Integer editedLines = companyRep.updateCompanyById(id, name);
        assertEquals(1, editedLines);

        Optional<Company> actualResult = companyRep.findById(id);
        actualResult.ifPresent(company -> {
           assertEquals(name, company.getName());
        });
    }

    @Test
    void deleteCompaniesByNameStartingWithTest() {
        String character = "A";

        var companies = companyRep.findAll();
        assertThat(companies).hasSize(3);

        companyRep.deleteCompaniesByNameStartingWith(character);

        companies = companyRep.findAll();
        assertThat(companies).hasSize(2);

    }
}
