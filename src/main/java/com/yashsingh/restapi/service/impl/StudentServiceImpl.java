package com.yashsingh.restapi.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.yashsingh.restapi.dto.AddStudentRequestDto;
import com.yashsingh.restapi.dto.StudentDto;
import com.yashsingh.restapi.entity.Student;
import com.yashsingh.restapi.repository.StudentRepository;
import com.yashsingh.restapi.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStduents() {
        List<Student> std = studentRepository.findAll();
        List<StudentDto> students = std
                .stream()
                .map((Student student) -> modelMapper.map(student, StudentDto.class))
                .toList();
        return students;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student std = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id " + id));
        return modelMapper.map(std, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto requestDto) {
        Student newStd = modelMapper.map(requestDto, Student.class);
        Student student = studentRepository.save(newStd);
        return modelMapper.map(student, StudentDto.class);
    }

    

}
