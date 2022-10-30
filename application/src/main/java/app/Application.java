package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Alex Mikhalevich
 * @created 2022-10-29 15:28
 */
@SpringBootApplication
@EnableJpaRepositories("repo")
@EntityScan("entities")
@ComponentScan({"interfaces", "impl", "dto", "mapper", "controller", "handler"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
