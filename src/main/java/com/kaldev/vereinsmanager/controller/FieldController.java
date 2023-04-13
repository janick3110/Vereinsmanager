package com.kaldev.vereinsmanager.controller;

import com.kaldev.vereinsmanager.Misc.Teams;
import com.kaldev.vereinsmanager.entity.Field;
import com.kaldev.vereinsmanager.entity.Player;
import com.kaldev.vereinsmanager.repository.FieldRepository;
import com.kaldev.vereinsmanager.repository.PlayerRepository;
import com.kaldev.vereinsmanager.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/fields")
public class FieldController {
    private FieldRepository fieldRepository;
    @Autowired
    private FieldService fieldService;

    public FieldController(FieldRepository repository) {
        this.fieldRepository = repository;
    }

    @GetMapping("")
    public List<Field> fieldList(){
        return fieldRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Field> get(@PathVariable Integer id) {
        try {
            Field field = fieldService.getField(id);
            return new ResponseEntity<>(field, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewField (
            @RequestParam String name,
            @RequestParam String segments
    ) {

        try {
            Field field = new Field();
            field.setName(name);
            field.setSegments(Integer.parseInt(segments));
            fieldService.saveUser(field);

            return "Saved";
        } catch (Exception e){
            return e.getStackTrace().toString();
        }
    }
}
