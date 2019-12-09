package com.example.demo;

import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class DemoApplication extends SpringBootServletInitializer {

    @Autowired
    BookService bookService;

    // Enable WAR packaging
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner myRunMethod() {
//        return (args) -> {
//            System.out.println("***Generating sample data***");
//            bookService.deleteAll();
//            bookService.generate(100);
//            System.out.println("***Done***");
//        };
//    }
}
