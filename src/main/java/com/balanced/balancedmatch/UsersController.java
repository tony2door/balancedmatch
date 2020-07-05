package com.balanced.balancedmatch;

import com.balanced.DTOs.UsersDTO;
import com.balanced.Entities.Users;
import com.balanced.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/users", produces = "application/json")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping
    public ResponseEntity<List<UsersDTO>> getUsersByGroupFromTeam(@RequestParam(value = "group") String group,
                                                               @RequestParam(value = "team") String team){
        List<UsersDTO> usersListFromGroupFromTeam = usersService.getUsersByGroupAndTeam(group, team);
        return new ResponseEntity<>(usersListFromGroupFromTeam, HttpStatus.OK);
    }
}
