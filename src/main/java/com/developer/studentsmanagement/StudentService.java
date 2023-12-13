package com.developer.studentsmanagement;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private static StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public static void addNewStudent(Student student) {
        Optional<Student> studentByEmail =
                studentRepository.findByEmail(student.getMail());
        if(studentByEmail.isPresent()) {
            try {
                throw new IllegalAccessException("email taken");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        studentRepository.save(student);
    }

    public static void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException(
                    "student with if " + id + " doesn't exists"
            );
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public static void updateStudent(Long id, String lastName, String mail) {
        Student myStudent = studentRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(
                        "student with id " + id + "doesn't exists")
        );
        if(lastName != null && lastName.length() > 0 &&
                !Objects.equals(myStudent.getLastName(), lastName)) {
            myStudent.setLastName(lastName);
        }
        if(mail != null && mail.length() > 0 &&
                !Objects.equals(myStudent.getMail(), mail)) {
            Optional<Student> studentOptional = studentRepository.findByEmail(mail);
            if(studentOptional.isPresent()) {
                throw new IllegalStateException("mail taken");
            }
            myStudent.setMail(mail);
        }
    }
}