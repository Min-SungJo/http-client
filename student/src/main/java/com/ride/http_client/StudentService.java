package com.ride.http_client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Integer saveStudent(Student student) {
        return repository.save(student).getId();
    }

    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    public List<Student> findAllStudentBySchoolId(Integer schoolId) {
        return repository.findAllBySchoolId(schoolId);
    }
}