package com.zemch.zemuniversityapplication.service.student;

import com.zemch.zemuniversityapplication.dto.StudentRequestDTO;
import com.zemch.zemuniversityapplication.model.Student;
import com.zemch.zemuniversityapplication.model.UniversityGroup;
import com.zemch.zemuniversityapplication.repository.GroupRepository;
import com.zemch.zemuniversityapplication.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentServiceImpl implements StudentService {

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(StudentRequestDTO studentRequestDTO) {
        UniversityGroup groupFromDb = groupRepository.findById(studentRequestDTO.getGroupId())
                .orElseThrow(() -> {
                    throw new IllegalStateException("Группы с таким ID - нет");
                });

        Student studentToDb = Student.builder()
                .name(studentRequestDTO.getName())
                .universityGroup(groupFromDb)
                .createdAt(LocalDate.now())
                .build();

        studentRepository.save(studentToDb);
    }
}
