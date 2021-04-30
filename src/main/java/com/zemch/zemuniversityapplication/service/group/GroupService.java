package com.zemch.zemuniversityapplication.service.group;

import com.zemch.zemuniversityapplication.dto.AllGroupResponseDTO;
import com.zemch.zemuniversityapplication.dto.UniversityGroupResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GroupService {

    void addGroup(String name);

    UniversityGroupResponseDTO getGroupById(Long id);

    List<AllGroupResponseDTO> getAllGroups();
}
