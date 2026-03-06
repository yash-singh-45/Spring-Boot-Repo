package com.example.studentmanagement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService stdService;

    public StudentController(StudentService stdService) {
        this.stdService = stdService;
    }

    // Get All Students
    @GetMapping
    public List<Student> getAllStudents() {
        return stdService.getAllStudents();
    }

    // Get Student by Id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getMethodName(@PathVariable Long id) {
        return stdService.getStudentbyId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    // POST - add Student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return stdService.addStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {   
        return stdService.updateStudent(id, student)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    
    //DELETE 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        if(stdService.deleteStudent(id)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
