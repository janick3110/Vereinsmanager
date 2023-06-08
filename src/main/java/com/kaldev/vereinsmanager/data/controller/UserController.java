package com.kaldev.vereinsmanager.data.controller;

import com.kaldev.vereinsmanager.data.entity.User;
import com.kaldev.vereinsmanager.data.repository.UserRepository;
import com.kaldev.vereinsmanager.data.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    private RolesService rolesService;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public List<User> userList(){
        return userRepository.findAll();
    }


    @PostMapping(path="/add")
    public ResponseEntity<Void> addNewUser (
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String email,
            @RequestParam String groupIDs,
            @RequestParam String roleIDs
    ) {

        try {

            User user = new User();
            user.setUsername(username);
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setPassword(password);
            user.setEmail(email);

            return ResponseEntity.ok().build();

        } catch (Exception e){
            System.out.println("An error has occured:" + e.getStackTrace());
            return ResponseEntity.badRequest().build();
        }

    }
}
