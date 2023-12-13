package com.developer.studentsmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
    public class StudentConfig {
        @Bean
        CommandLineRunner commandLineRunner (
                StudentRepository repository) {
            return args -> {
                Student alex = new Student(7L,
                        "Alexandru",
                        "Irimia",
                        "2001-01-15",
                        "Strada Armoniei","alexi@yahoo.com",
                        "0765956330");
                Student bg = new Student(2L,
                        "Bogdan",
                        "Lisandra",
                        "2002-08-09",
                        "Strada Principala",
                        "body@yahoo.com",
                        "0765543211");
               repository.saveAll(List.of(alex, bg));
                // Stergere student cu id-ul 7
               StudentService.deleteStudent(17L);
                StudentService.updateStudent(22L, "Filipinescu", "filipqqq@email.com");
            };
        }
    }
