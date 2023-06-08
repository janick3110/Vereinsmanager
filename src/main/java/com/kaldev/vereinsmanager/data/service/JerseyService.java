package com.kaldev.vereinsmanager.data.service;

import com.kaldev.vereinsmanager.data.entity.Jersey;
import com.kaldev.vereinsmanager.data.repository.JerseyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class JerseyService {
    @Autowired
    private JerseyRepository jerseyRepository;

    public List<Jersey> listAllJerseys() {
        return jerseyRepository.findAll();
    }

    public void saveUser(Jersey jersey) {
        jerseyRepository.save(jersey);
    }

    public Jersey getJersey(Integer id) {
        return jerseyRepository.findById(id).get();
    }

    public void deleteJersey(Integer id) {
        jerseyRepository.deleteById(id);
    }
}
