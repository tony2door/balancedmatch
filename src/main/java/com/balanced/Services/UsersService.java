package com.balanced.Services;

import com.balanced.Entities.Users;
import com.balanced.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Transactional
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }
}
