package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class StudentService {

    public final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * List of students
     * @return List<Student>
     */

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    /**
     * Create a student
     */
    public void createStudent(Student student){
        Optional<Student> studentFound = studentRepository.findStudentByEmail(student.getEmail());
        if (studentFound.isPresent()) {
                throw  new IllegalStateException("Student exists already!");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
            boolean exists = studentRepository.existsById(studentId);
            if(!exists) {
                throw new IllegalStateException("Invalid Student Id");
            }
            studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String email, String name){

           Student student =  studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Invalid User"));

           if(name != null && !name.isEmpty() && !Objects.equals(student.getEmail(), email)){
               student.setName(name);
           }

           if(email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email)){
                Optional<Student> studentExists = studentRepository.findStudentByEmail(email);
                if(studentExists.isPresent()) {
                    throw new IllegalStateException("Email already exists");
                }
                student.setEmail(email);
           }
    }

}
