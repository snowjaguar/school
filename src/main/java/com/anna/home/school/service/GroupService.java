package com.anna.home.school.service;

import com.anna.home.school.dto.AddGroupRequestDto;
import com.anna.home.school.dto.AllGroupsResponseDto;
import com.anna.home.school.dto.OneGroupResponseDto;
import com.anna.home.school.entity.Group;

import java.util.List;

public interface GroupService {
    public void addGroup(AddGroupRequestDto addGroupRequestDto);

    public OneGroupResponseDto getGroupById(Integer Id);

    public List<AllGroupsResponseDto> getAllGroups();
}
