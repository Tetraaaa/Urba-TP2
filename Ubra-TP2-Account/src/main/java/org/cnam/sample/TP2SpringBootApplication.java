package org.cnam.sample;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan("org.cnam.sample.repository.model")
@EnableJpaRepositories("org.cnam.sample.repository")
@EnableTransactionManagement
@EnableAutoConfiguration
public class TP2SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TP2SpringBootApplication.class, args);
    }

}
