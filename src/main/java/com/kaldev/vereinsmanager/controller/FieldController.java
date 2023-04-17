package com.kaldev.vereinsmanager.controller;

import com.kaldev.vereinsmanager.entity.Field;
import com.kaldev.vereinsmanager.repository.FieldRepository;
import com.kaldev.vereinsmanager.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public @ResponseBody HttpStatus addNewField (
            @RequestParam String name,
            @RequestParam String segments
    ) {

        try {
            Field field = new Field();
            field.setName(name);
            field.setSegments(Integer.parseInt(segments));
            fieldService.saveUser(field);

            return HttpStatus.OK;

        } catch (Exception e){
            return HttpStatus.BAD_REQUEST;
        }
    }
}
