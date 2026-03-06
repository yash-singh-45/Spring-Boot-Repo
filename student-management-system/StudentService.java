package com.example.studentmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final List<Student> stdList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Student> getAllStudents(){
        return stdList;
    }

    public Optional<Student> getStudentbyId(Long id){
        return stdList.stream().filter(s-> s.getId() == id).findFirst();
    }

    public Student addStudent(Student std){
        std.setId(idCounter.getAndIncrement());
        stdList.add(std);
        return std;
    }

    public Optional<Student> updateStudent(Long id, Student updatedStudent){
        return getStudentbyId(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setDepartment(updatedStudent.getDepartment());
            student.setAge(updatedStudent.getAge());
            return student;
        });
    }

    public boolean deleteStudent(Long id){
        return stdList.removeIf( s -> s.getId().equals(id));
    }
}
