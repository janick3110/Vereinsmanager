package com.kaldev.vereinsmanager.controller;

import com.kaldev.vereinsmanager.entity.SportsActivity;
import com.kaldev.vereinsmanager.repository.SportsActivityRepository;
import com.kaldev.vereinsmanager.service.SportsActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/activities")
public class SportsActivityController {
    private SportsActivityRepository sportsActivityRepository;

    @Autowired
    private SportsActivityService sportsActivityService;


    public SportsActivityController(SportsActivityRepository sportsActivityRepository) {
        this.sportsActivityRepository = sportsActivityRepository;
    }

    @GetMapping("")
    public List<SportsActivity> groupList(){
        return sportsActivityRepository.findAll();
    }


    @PostMapping(path="/add")
    public ResponseEntity<Void> addNewActivity (
            @RequestParam String name,
            @RequestParam int responsibleId
    ) {

        try {

            SportsActivity sportsActivity = new SportsActivity();
            sportsActivity.setName(name);
            sportsActivity.setResponsibleID(responsibleId);


            return ResponseEntity.ok().build();

        } catch (Exception e){
            System.out.println("An error has occured:" + e.getStackTrace());
            return ResponseEntity.badRequest().build();
        }

    }

}
