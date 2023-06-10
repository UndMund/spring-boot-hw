package by.itacademy.spring.database.repository;

import by.itacademy.spring.database.entity.Company;
import by.itacademy.spring.database.entity.User;
import by.itacademy.spring.database.pool.ConnectionPool;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Modifying
    @Query(value = """
                UPDATE Company c 
                SET c.name = :name
                WHERE c.id = :id
            """)
    Integer updateCompanyById(Integer id, String name);


    void deleteCompaniesByNameStartingWith(String name);



}
