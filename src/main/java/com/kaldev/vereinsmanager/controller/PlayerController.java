package com.kaldev.vereinsmanager.controller;

import com.kaldev.vereinsmanager.entity.Player;
import com.kaldev.vereinsmanager.repository.PlayerRepository;
import com.kaldev.vereinsmanager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/player")
public class PlayerController {

    private PlayerRepository playerRepository;
    @Autowired
    private PlayerService playerService;

    public PlayerController(PlayerRepository repository) {
        this.playerRepository = repository;
    }

    @GetMapping("")
    public List<Player> playerList(){
        return playerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> get(@PathVariable Integer id) {
        try {
            Player user = playerService.getUser(id);
            return new ResponseEntity<Player>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path="/add")
    public @ResponseBody HttpStatus addNewPlayer (
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String birthday,
            @RequestParam String street,
            @RequestParam String housenumber,
            @RequestParam String city,
            @RequestParam String postalCode,
            @RequestParam String mailAdress,
            @RequestParam String telephone
            ) {

        try {
            Player player = new Player();

            player.setFirstname(firstname);
            player.setLastname(lastname);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMAN);
            player.setDate(formatter.parse(birthday));
            player.setStreet(street);
            player.setHousenumber(Integer.parseInt(housenumber));
            player.setCity(city);
            player.setPostalCode(Integer.parseInt(postalCode));
            player.setMailAdress(mailAdress);
            player.setTelephoneNumber(telephone);
            //ToDo: Set Team via ID
            //player.setTeam(team);


            playerRepository.save(player);
            return HttpStatus.OK;

        } catch (Exception e){
            return HttpStatus.BAD_REQUEST;
        }
    }
}
