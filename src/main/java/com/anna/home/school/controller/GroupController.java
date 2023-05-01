package com.anna.home.school.controller;

import com.anna.home.school.dto.AddGroupRequestDto;
import com.anna.home.school.dto.AllGroupsResponseDto;
import com.anna.home.school.dto.OneGroupResponseDto;
import com.anna.home.school.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<AllGroupsResponseDto> getAllGroups() {
        List<AllGroupsResponseDto> groups = groupService.getAllGroups();
        return groups;
    }

    @GetMapping(path = "/{id}")
    public OneGroupResponseDto getGroupById(@PathVariable Integer id) {
        OneGroupResponseDto oneGroupResponseDto = groupService.getGroupById(id);
        return oneGroupResponseDto;
    }

    @PostMapping
    public void addGroup(@RequestBody AddGroupRequestDto addGroupRequestDto) {
        groupService.addGroup(addGroupRequestDto);
    }

}
