package by.itacademy.annotation;


import by.itacademy.TestApplicationRunner;
import by.itacademy.spring.ApplicationRunner;
import by.itacademy.testConfig.TestConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ActiveProfiles("test")
@SpringBootTest(classes = {TestConfig.class, ApplicationRunner.class})
public @interface IT {
}
