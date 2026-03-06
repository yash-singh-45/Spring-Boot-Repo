package com.yashsingh.restapi.service;
import java.util.List;


import com.yashsingh.restapi.dto.AddStudentRequestDto;
import com.yashsingh.restapi.dto.StudentDto;
public interface StudentService {

    List<StudentDto> getAllStduents();
    StudentDto getStudentById(Long id);
    StudentDto createNewStudent(AddStudentRequestDto requestDto);
}
