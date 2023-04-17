package com.kaldev.vereinsmanager.controller;

import com.kaldev.vereinsmanager.entity.Jersey;
import com.kaldev.vereinsmanager.entity.Player;
import com.kaldev.vereinsmanager.entity.Responsible;
import com.kaldev.vereinsmanager.repository.JerseyRepository;
import com.kaldev.vereinsmanager.repository.ResponsibleRepository;
import com.kaldev.vereinsmanager.service.ResponsibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/persons")
public class ResponsibleController {
    private ResponsibleRepository responsibleRepository;

    @Autowired
    private ResponsibleService responsibleService;

    public ResponsibleController(ResponsibleRepository repository) {
        this.responsibleRepository = repository;
    }

    @GetMapping("")
    public List<Responsible> responsibleList(){
        return responsibleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsible> get(@PathVariable Integer id) {
        try {
            Responsible responsible = responsibleService.getResponsible(id);
            return new ResponseEntity<Responsible>(responsible, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Responsible>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path="/add")
    public @ResponseBody HttpStatus addNewPlayer (
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String street,
            @RequestParam String housenumber,
            @RequestParam String city,
            @RequestParam String postalCode,
            @RequestParam String mailAdress,
            @RequestParam String telephone
    ) {

        try {
            Responsible responsible = new Responsible();

            responsible.setFirstname(firstname);
            responsible.setLastname(lastname);
            responsible.setStreet(street);
            responsible.setHousenumber(Integer.parseInt(housenumber));
            responsible.setCity(city);
            responsible.setPostalCode(Integer.parseInt(postalCode));
            responsible.setMailAdress(mailAdress);
            responsible.setTelephoneNumber(telephone);
            //ToDo: Set Team via ID
            //player.setTeam(team);


            responsibleRepository.save(responsible);
            return HttpStatus.OK;

        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJersey(@PathVariable int id) {
        try {
            responsibleRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}