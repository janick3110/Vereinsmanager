package com.kaldev.vereinsmanager.controller;

import com.kaldev.vereinsmanager.entity.Jersey;
import com.kaldev.vereinsmanager.entity.Player;
import com.kaldev.vereinsmanager.repository.JerseyRepository;
import com.kaldev.vereinsmanager.repository.PlayerRepository;
import com.kaldev.vereinsmanager.service.JerseyService;
import com.kaldev.vereinsmanager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public @ResponseBody HttpStatus addNewJersey (@RequestParam String sponsorName) {

        try {
            Jersey jersey = new Jersey();

            jersey.setSponsor(sponsorName);

            Random random = new Random();
            List<Integer> numbers = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                numbers.add(random.nextInt(1,99));
            }
            Collections.sort(numbers);

            jersey.setNumbers(numbers);
            jerseyRepository.save(jersey);

            return HttpStatus.OK;
        } catch (Exception e){
            return HttpStatus.BAD_REQUEST;
        }

    }


}
