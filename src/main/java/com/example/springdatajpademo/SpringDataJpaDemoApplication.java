package com.example.springdatajpademo;

import com.example.springdatajpademo.entity.User;
import com.example.springdatajpademo.repository.UserRepository;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User user = new User();
            userRepository.save(user);

            List<User> all = userRepository.findAll();
            System.out.println(all);
        };
    }

}
