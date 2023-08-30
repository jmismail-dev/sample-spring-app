package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {

    public final StudentService studentService;
    private Long studentId;
    private String name;
    private String email;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return  studentService.getStudents();
    }

    @PostMapping
    public void createStudent(@RequestBody  Student student){
            studentService.createStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long StudentId){
        studentService.deleteStudent(StudentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestBody Student student
    ){
        studentService.updateStudent(
                studentId,
                student.getEmail(),
                student.getName()

        );
    }
}
