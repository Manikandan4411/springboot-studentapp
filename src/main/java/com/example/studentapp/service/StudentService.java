package com.example.studentapp.service;

import com.example.studentapp.entity.Student;
import com.example.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    //create
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    //Readall
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // READ BY ID (IMPORTANT ADDITION)
    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    //delete
    public void deleteStudent(Long id) {
    repository.deleteById(id);
    }

    // UPDATE (PATCH STYLE)
    public Student updateStudent(Long id, Student student) {

        Student existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        if (student.getName() != null) {
            existingStudent.setName(student.getName());
        }

        if (student.getEmail() != null) {
            existingStudent.setEmail(student.getEmail());
        }

        return repository.save(existingStudent);
    }

    @PutMapping("/{id}")
    public Student replaceStudent(Long id, Student student) {
        Student existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAge(student.getAge());

        return repository.save(existingStudent);
    }
}

