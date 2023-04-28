package com.kaldev.vereinsmanager.service;

import com.kaldev.vereinsmanager.entity.SportsActivity;
import com.kaldev.vereinsmanager.repository.SportsActivityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SportsActivityService {
    @Autowired
    private SportsActivityRepository sportsActivityRepository;

    public List<SportsActivity> listAllGroups() {
        return sportsActivityRepository.findAll();
    }


    public void saveGroup(SportsActivity sportsActivity) {
        sportsActivityRepository.save(sportsActivity);
    }

    public SportsActivity getGroup(Integer id) {
        return sportsActivityRepository.findById(id).get();
    }

    public void deleteGroup(Integer id) {
        sportsActivityRepository.deleteById(id);
    }
}
