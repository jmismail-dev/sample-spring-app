package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
            return args -> {
                Student mohamedIsmail = new Student(
                        "Mohamed Ismail",
                        "ismail@gmail.com",
                        LocalDate.of(1996, Month.JUNE, 28),
                        21

                );

                Student mohamedBasith = new Student(
                        "Mohamed Basith",
                        "basith@valorpaytech.com",
                        LocalDate.of(1996, Month.JANUARY, 3),
                        21
                );

                Student sadhamHussain = new Student(
                        "Sadham Hussain",
                        "sadham@valorpaytech.com",
                        LocalDate.of(1997, Month.JANUARY, 3),
                        21
                );

//                studentRepository.saveAll(List.of(mohamedIsmail, mohamedBasith, sadhamHussain));
            };
    };
}
