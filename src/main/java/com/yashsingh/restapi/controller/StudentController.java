package com.yashsingh.restapi.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.yashsingh.restapi.dto.AddStudentRequestDto;
import com.yashsingh.restapi.dto.StudentDto;
import com.yashsingh.restapi.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStduents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getMethodName(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody@Valid AddStudentRequestDto requestStd) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(requestStd));
    }
}
