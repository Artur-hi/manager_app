package com.zemch.zemuniversityapplication.controller;

import com.zemch.zemuniversityapplication.dto.StudentRequestDTO;
import com.zemch.zemuniversityapplication.service.student.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping(path = "/add")
    public void addStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        studentService.addStudent(studentRequestDTO);
    }
}
