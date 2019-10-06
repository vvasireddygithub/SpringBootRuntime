package com.stealth.b2b;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.stealth.b2b")
@EnableJpaRepositories(basePackages="com.stealth.b2b")
@EnableTransactionManagement
@EntityScan(basePackages="com.stealth.b2b")
public class Application {
    public static void main(String[] args) {
    	org.springframework.context.ConfigurableApplicationContext context = 
    			SpringApplication.run(Application.class, args);
    }
}
