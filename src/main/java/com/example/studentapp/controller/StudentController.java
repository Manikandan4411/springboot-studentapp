package com.example.studentapp.controller;

import com.example.studentapp.entity.Student;
import com.example.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // CREATE
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    // READ ALL
    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    // READ BY ID (IMPORTANT)
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Deleted student with id: " + id;
    }

    // UPDATE (PATCH)
    @PatchMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @PutMapping("/{id}")
    public Student replaceStudent(@PathVariable Long id,    
                                  @RequestBody Student student) {
        // For PUT, we expect the entire student object to be provided.
        // We can reuse the updateStudent method since it handles null checks.
        return service.updateStudent(id, student);
    }   
}