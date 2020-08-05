package com.balanced.Converters;

import com.balanced.DTOs.UsersDTO;
import com.balanced.Entities.Users;
import org.springframework.stereotype.Service;

@Service
public class Converter {

    public UsersDTO convertUsersEntitytoDTO(Users entity){
        UsersDTO dto = new UsersDTO();
        dto.setUserName(entity.getUserName());
        dto.setUserPassword(entity.getUserPassword());
        dto.setPlayerAttack(entity.getPlayerAttack());
        dto.setPlayerDefence(entity.getPlayerDefence());
        dto.setPlayerDribbling(entity.getPlayerDribbling());
        dto.setPlayerFirstTouch(entity.getPlayerFirstTouch());
        dto.setPlayerMiddle(entity.getPlayerMiddle());
        dto.setPlayerPace(entity.getPlayerPace());
        dto.setPlayerPass(entity.getPlayerPass());
        dto.setPlayerStamina(entity.getPlayerStamina());
        dto.setPlayerVision(entity.getPlayerVision());
        dto.setPlayerRole(entity.getPlayerRole());
        dto.setGroupName(entity.getGroupOfUsersForeign().getGroupName());
        dto.setTeamName(entity.getTeamsForeign().getTeamName());
        dto.setPlayerAverage(entity.getPlayerAverage());
        return dto;
    }
}
