package Homework.nineteenth.Configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages = {"Homework.nineteenth"})
public class Config {
}
