package com.balanced.Services;

import com.balanced.Converters.Converter;
import com.balanced.DTOs.UsersDTO;
import com.balanced.Entities.Users;
import com.balanced.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    Converter converter;

    @Transactional
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }
    @Transactional
    public List<UsersDTO> getUsersByGroupAndTeam (String group, String team){

        List<Users> temp = usersRepository.getUsersByGroupOfUsersForeignGroupNameAndTeamsForeignTeamName(group, team);
        List<UsersDTO> listDTO = new ArrayList<>();

        for (Users users : temp) {
            UsersDTO dtoConvert = converter.convertUsersEntitytoDTO(users);
            listDTO.add(dtoConvert);
        }
        return listDTO;
    }
}
