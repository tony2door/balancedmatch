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
import java.util.*;
import java.util.stream.IntStream;

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
    public List<UsersDTO> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        List<UsersDTO> dto = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            UsersDTO dtoConvert = converter.convertUsersEntitytoDTO(users.get(i));
            dto.add(dtoConvert);
        }
        return dto;
    }

    @Transactional
    public List<UsersDTO> getUsersByGroupAndTeam(String group, String team) {

        List<GroupOfUsers> groupOfUsersList = groupsRepository.findAll();
        List<Teams> teamsList = teamsRepository.findAll();
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

    @Transactional
    public void calculateAverage(){
        List<Users> usersList = usersRepository.findAll();

        for (int i = 0; i < usersList.size(); i++) {
            Users user = usersList.get(i);
            IntStream playerSkills = IntStream.of(user.getPlayerStamina(),user.getPlayerPace(), user.getPlayerDribbling(), user.getPlayerVision(),
                    user.getPlayerFirstTouch(), user.getPlayerPass(),user.getPlayerDefence(),user.getPlayerMiddle(),user.getPlayerAttack());
            OptionalDouble res = playerSkills.average();
            if(res.isPresent()){
                usersRepository.setAverage(res.getAsDouble(),user.getUserId());
            }
            else {
                throw new IllegalStateException("Something went wrong!");
            }
        }
    }

    @Transactional
    public void doTeamSeparation (Integer groupId) {
        List<Users> sortedUsersList = usersRepository.sortedUsersFromGroup(groupId);
        Teams teamsA = new Teams();
        Teams teamsB = new Teams();

        for (int i = 0; i < sortedUsersList.size(); i++) {
            Users user = sortedUsersList.get(i);
            for (int j = 1; j <= 2; j++) {
            if (i == 0 || i%2==0){
                teamsA.setTeamId(1);
                user.setTeamsForeign(teamsA);
            }
            else {
                teamsB.setTeamId(2);
                user.setTeamsForeign(teamsB);
            }
            }
        }
    }
}