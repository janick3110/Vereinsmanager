package com.kaldev.vereinsmanager.controller;

import com.kaldev.vereinsmanager.entity.Jersey;
import com.kaldev.vereinsmanager.repository.JerseyRepository;
import com.kaldev.vereinsmanager.service.JerseyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/jersey")
public class JerseyController {
    private JerseyRepository jerseyRepository;

    @Autowired
    private JerseyService jerseyService;

    public JerseyController(JerseyRepository repository) {
        this.jerseyRepository = repository;
    }

    @GetMapping("")
    public List<Jersey> playerList(){
        return jerseyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jersey> get(@PathVariable Integer id) {
        try {
            Jersey user = jerseyService.getJersey(id);
            return new ResponseEntity<Jersey>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Jersey>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path="/add")
    public ResponseEntity<Void> addNewJersey (
            @RequestParam String team,
            @RequestParam String sponsorName,
            @RequestParam String numbers,
            @RequestParam int amountPants,
            @RequestParam int amountSocks,
            @RequestParam int year,
            @RequestParam String image
            ) {

        try {
            Jersey jersey = new Jersey();

            jersey.setSponsor(sponsorName);


            List<Integer> numberList = Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            jersey.setNumbers(numberList);
            jersey.setYear(year);
            jersey.setAmountPants(amountPants);
            jersey.setAmountSocks(amountSocks);
            jersey.setBase64image(image);
            //ToDo: SetTeam needs to set a group via ID
            //jersey.setTeam(Teams.GetTeamFromString(team));

            jerseyRepository.save(jersey);

            return ResponseEntity.noContent().build();

        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }



    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJersey(@PathVariable int id) {
        try {
            jerseyRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }



}
