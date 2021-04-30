package com.zemch.zemuniversityapplication.service.group;

import com.zemch.zemuniversityapplication.dto.AllGroupResponseDTO;
import com.zemch.zemuniversityapplication.dto.StudentResponseDTO;
import com.zemch.zemuniversityapplication.dto.UniversityGroupResponseDTO;
import com.zemch.zemuniversityapplication.model.Student;
import com.zemch.zemuniversityapplication.model.UniversityGroup;
import com.zemch.zemuniversityapplication.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void addGroup(String name) {

        UniversityGroup toSave = UniversityGroup.builder()
                .name(name)
                .createdAt(LocalDate.now())
                .build();
        groupRepository.save(toSave);
    }

    @Override
    public UniversityGroupResponseDTO getGroupById(Long id) {

        UniversityGroup groupFromDb = groupRepository
                .findById(id)
                .orElseThrow(() -> {
                    throw new IllegalStateException("Группы с таким ID - нет");
                });


        return UniversityGroupResponseDTO.builder()
                .id(groupFromDb.getId())
                .name(groupFromDb.getName())
                .list(getStudentDTOList(groupFromDb))
                .build();
    }

    @Override
    public List<AllGroupResponseDTO> getAllGroups() {
        return groupRepository.findAll()
                .stream()
                .map(this::getAllGroupResponseDTOFromGroup)
                .collect(Collectors.toList());
    }

    private AllGroupResponseDTO getAllGroupResponseDTOFromGroup(UniversityGroup group) {
        return AllGroupResponseDTO.builder()
                .name(group.getName())
                .studentQuantity(group.getStudents().size())
                .build();
    }



    private List<StudentResponseDTO> getStudentDTOList(UniversityGroup groupFromDb) {
        return groupFromDb.getStudents()
                .stream()
                .map(student -> getStudentResponseDTO(student))
                .collect(Collectors.toList());
    }


    private StudentResponseDTO getStudentResponseDTO(Student student) {
        return StudentResponseDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .createAt(student.getCreatedAt())
                .build();
    }
}
