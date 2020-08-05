package com.balanced.Services;

import com.balanced.Entities.GroupOfUsers;
import com.balanced.repositories.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class GroupsService {

    @Autowired
    GroupsRepository groupsRepository;

    @Transactional
    public List<GroupOfUsers> getAllGroups (){
        return groupsRepository.findAll();
    }
}
