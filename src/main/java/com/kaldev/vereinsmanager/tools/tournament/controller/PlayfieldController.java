package com.kaldev.vereinsmanager.tools.tournament.controller;

import com.kaldev.vereinsmanager.tools.tournament.entity.Game;
import com.kaldev.vereinsmanager.tools.tournament.entity.Playfield;
import com.kaldev.vereinsmanager.tools.tournament.entity.Team;
import com.kaldev.vereinsmanager.tools.tournament.repository.GameRepository;
import com.kaldev.vereinsmanager.tools.tournament.repository.PlayfieldRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tournament/playfields")
public class PlayfieldController {
    private PlayfieldRepository playfieldRepository;


    public PlayfieldController(PlayfieldRepository playfieldRepository) {
        this.playfieldRepository = playfieldRepository;
    }

    @GetMapping("")
    public List<Playfield> playfields(){
        return playfieldRepository.findAll();
    }

    @PostMapping("/new")
    public @ResponseBody HttpStatus addNewField (
            @RequestParam String name,
            @RequestParam int idOfTournament
    ) {

        try {
            Playfield playfield = new Playfield();

            playfield.setIdOfTournament(idOfTournament);
            playfield.setName(name);

            playfieldRepository.save(playfield);

            return HttpStatus.OK;

        } catch (Exception e){
            return HttpStatus.BAD_REQUEST;
        }
    }
}
