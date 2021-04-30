package com.zemch.zemuniversityapplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zemch.zemuniversityapplication.dto.StudentRequestDTO;
import com.zemch.zemuniversityapplication.model.Student;
import com.zemch.zemuniversityapplication.model.UniversityGroup;
import com.zemch.zemuniversityapplication.repository.GroupRepository;
import com.zemch.zemuniversityapplication.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    StudentRepository studentRepository;
    UniversityGroup group;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {

        group = UniversityGroup.builder()
                .name("English")
                .build();
        groupRepository.save(group);
    }

    @Test
    void addStudent() throws Exception {

        StudentRequestDTO evgeniy = StudentRequestDTO.builder()
                .name("Evgeniy")
                .groupId(group.getId())
                .build();

        String string = objectMapper.writeValueAsString(evgeniy);

        mockMvc.perform(post("/student/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(string))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());


        List<Student> students = studentRepository.findAllByUniversityGroupId(group.getId());

        Assertions.assertEquals(1, students.size());

        Student student = students.get(0);

        Assertions.assertEquals(group.getId(),student.getUniversityGroup().getId());
    }
}