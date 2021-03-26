package Homework.twentieth.Configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages = {"Homework.twentieth"})
public class Config {
}
