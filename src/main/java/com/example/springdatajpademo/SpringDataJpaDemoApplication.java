package com.example.springdatajpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(UserRepository userRepository) {
//        return args -> {
//            User user = new User();
//            userRepository.save(user);
//
//            List<User> all = userRepository.findAll();
//            System.out.println(all);
//        };
//    }

}
