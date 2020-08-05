package com.balanced.balancedmatch;
import com.balanced.DTOs.UsersDTO;
import com.balanced.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping(value = "/users")
    public ResponseEntity<List<UsersDTO>> getUsersByGroupFromTeam(@RequestParam(value = "group") String group,
                                                               @RequestParam(value = "team") String team){
        usersService.calculateAverage();
        List<UsersDTO> usersListFromGroupFromTeam = usersService.getUsersByGroupAndTeam(group, team);
        return new ResponseEntity<>(usersListFromGroupFromTeam, HttpStatus.OK);
    }

    @GetMapping(value = "/allusers", produces = "application/json")
    public ResponseEntity<List<UsersDTO>> getAllUsers(){
        usersService.calculateAverage();
        usersService.doTeamSeparation(1);
        List<UsersDTO> usersList = usersService.getAllUsers();
        return new ResponseEntity<>(usersList,HttpStatus.OK);
    }
}
