package com.balanced.Services;

import com.balanced.repositories.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class GroupsService {

    @Autowired
    GroupsRepository groupsRepository;

}
