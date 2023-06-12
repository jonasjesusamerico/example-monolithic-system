package br.com.jonasdev.simplefinancialcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan("br.com.jonasdev.*")
public class SimpleFinancialControlApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SimpleFinancialControlApplication.class, args);
    }

}
