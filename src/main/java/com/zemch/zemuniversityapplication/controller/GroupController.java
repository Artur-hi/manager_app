package com.zemch.zemuniversityapplication.controller;


import com.zemch.zemuniversityapplication.dto.AllGroupResponseDTO;
import com.zemch.zemuniversityapplication.dto.UniversityGroupResponseDTO;
import com.zemch.zemuniversityapplication.service.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/group")
public class GroupController {

    @Autowired
    GroupService groupService;


    @PostMapping(path = "/add")
    public void addGroup(@RequestParam String name) {
        groupService.addGroup(name);
    }


    @GetMapping(path = "/get")
    public UniversityGroupResponseDTO getGroupById(@RequestParam Long id) {
        return groupService.getGroupById(id);
    }

    @GetMapping(path = "/getAll")
    public List<AllGroupResponseDTO> getAllGroups() {
        return groupService.getAllGroups();
    }
}
