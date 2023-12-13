package com.developer.studentsmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "EvidentaStudentilor")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{StudentId}")
    public void  deleteStudent(@PathVariable("StudentId") Long id) {
        studentService.deleteStudent(id);
    }
    @PutMapping(path = {"StudentId"})
    public void updateStudent (@PathVariable("StudentId") Long id,
                               @RequestParam(required = false) String lastName,
                               @RequestParam(required = false) String mail) {
        studentService.updateStudent(id, lastName, mail);

    }
}
