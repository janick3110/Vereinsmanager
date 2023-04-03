package com.kaldev.vereinsmanager.service;

import com.kaldev.vereinsmanager.entity.Field;
import com.kaldev.vereinsmanager.entity.Player;
import com.kaldev.vereinsmanager.repository.FieldRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FieldService {
    @Autowired
    private FieldRepository fieldRepository;

    public List<Field> listAllFields() {
        return fieldRepository.findAll();
    }


    public void saveUser(Field field) {
        fieldRepository.save(field);
    }

    public Field getField(Integer id) {
        return fieldRepository.findById(id).get();
    }

    public void deleteField(Integer id) {
        fieldRepository.deleteById(id);
    }
}
