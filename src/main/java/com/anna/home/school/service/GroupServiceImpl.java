package com.anna.home.school.service;

import com.anna.home.school.dto.AddGroupRequestDto;
import com.anna.home.school.dto.AllGroupsResponseDto;
import com.anna.home.school.dto.OneGroupResponseDto;
import com.anna.home.school.entity.Group;
import com.anna.home.school.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public void addGroup(AddGroupRequestDto addGroupRequestDto) {
        Group group = new Group();
        group.setNumber(addGroupRequestDto.getNumber());
        groupRepository.save(group);
    }

    @Override
    public OneGroupResponseDto getGroupById(Integer id) {
        Group group = null;
        Optional<Group> optional = groupRepository.findById(id);
        if (optional.isPresent()) {
            group = optional.get();
        }

        OneGroupResponseDto oneGroupResponseDto = new OneGroupResponseDto();
        oneGroupResponseDto.setId(group.getId());
        oneGroupResponseDto.setNumber((group.getNumber()));

        return oneGroupResponseDto;
    }

    @Override
    public List<AllGroupsResponseDto> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        List<AllGroupsResponseDto> groupsDtoList = groups.stream()
                .map(group -> {
                    AllGroupsResponseDto allGroupsResponseDto = new AllGroupsResponseDto();
                    allGroupsResponseDto.setId(group.getId());
                    allGroupsResponseDto.setNumber(group.getNumber());
                    allGroupsResponseDto.setStudents(group.getStudents().size());
                    return allGroupsResponseDto;
                }).collect(Collectors.toList());

        return groupsDtoList;
    }

}
