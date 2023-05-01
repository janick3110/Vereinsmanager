package com.kaldev.vereinsmanager.controller;

import com.kaldev.vereinsmanager.entity.Roles;
import com.kaldev.vereinsmanager.entity.SportsActivity;
import com.kaldev.vereinsmanager.repository.RolesRepository;
import com.kaldev.vereinsmanager.repository.SportsActivityRepository;
import com.kaldev.vereinsmanager.service.RolesService;
import com.kaldev.vereinsmanager.service.SportsActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/roles")
public class RolesController {
    private RolesRepository rolesRepository;

    @Autowired
    private RolesService rolesService;


    public RolesController(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @GetMapping("")
    public List<Roles> rolesList(){
        return rolesRepository.findAll();
    }


    @PostMapping(path="/add")
    public ResponseEntity<Void> addNewActivity (
            @RequestParam String name,
            @RequestParam int id
    ) {

        try {

            Roles role = new Roles();

            role.setName(name);
            rolesRepository.save(role);

            return ResponseEntity.ok().build();

        } catch (Exception e){
            System.out.println("An error has occured:" + e.getStackTrace());
            return ResponseEntity.badRequest().build();
        }

    }
}
