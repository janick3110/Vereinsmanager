package com.kaldev.vereinsmanager.controller;

import com.kaldev.vereinsmanager.Misc.Teams;
import com.kaldev.vereinsmanager.entity.Jersey;
import com.kaldev.vereinsmanager.entity.Player;
import com.kaldev.vereinsmanager.repository.PlayerRepository;
import com.kaldev.vereinsmanager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController()
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
    public @ResponseBody String addNewPlayer (
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String birthday,
            @RequestParam String street,
            @RequestParam String housenumber,
            @RequestParam String city,
            @RequestParam String postalCode,
            @RequestParam String mailAdress,
            @RequestParam String telephone,
            @RequestParam Teams.teams team
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
            //TODO: Change default team value
            player.setTeam(Teams.teams.ARCHIVE);


            playerRepository.save(player);

            return "Saved";
        } catch (Exception e){
            return e.getStackTrace().toString();
        }
    }
}
