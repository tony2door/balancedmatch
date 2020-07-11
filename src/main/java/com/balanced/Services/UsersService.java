package com.balanced.Services;

import com.balanced.Converters.Converter;
import com.balanced.DTOs.UsersDTO;
import com.balanced.Entities.GroupOfUsers;
import com.balanced.Entities.Teams;
import com.balanced.Entities.Users;
import com.balanced.repositories.GroupsRepository;
import com.balanced.repositories.TeamsRepository;
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
    GroupsRepository groupsRepository;

    @Autowired
    TeamsRepository teamsRepository;

    @Autowired
    Converter converter;

    @Transactional
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Transactional
    public List<UsersDTO> getUsersByGroupAndTeam(String group, String team) {

        List<GroupOfUsers> groupOfUsersList = groupsRepository.getAllGroups();
        List<Teams> teamsList = teamsRepository.getAllTeams();
        List<UsersDTO> listDTO = new ArrayList<>();
        for (int j = 0; j < groupOfUsersList.size(); j++) {

            String groupsWordsWithSpace = groupOfUsersList.get(j).getGroupName();
            String groupsNoSpaceWords = groupOfUsersList.get(j).getGroupName().toLowerCase().replaceAll("\\s+", "");

            if (groupsNoSpaceWords.equals(group)) {

                for (int i = 0; i < teamsList.size(); i++) {
                    String teamsWordsWithSpace = teamsList.get(i).getTeamName();
                    String teamsNoSpaceWords = teamsList.get(i).getTeamName().toLowerCase().replaceAll("\\s+", "");
                    if (teamsNoSpaceWords.equals(team)) {
                        List<Users> temp = usersRepository.getUsersByGroupOfUsersForeignGroupNameAndTeamsForeignTeamName(groupsWordsWithSpace, teamsWordsWithSpace);

                        for (int z = 0; z < temp.size(); z++) {
                            Users users = temp.get(z);
                            UsersDTO dtoConvert = converter.convertUsersEntitytoDTO(users);
                            listDTO.add(dtoConvert);
                        }
                    }
                }
            }
        }
        return listDTO;
    }
}
