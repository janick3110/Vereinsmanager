package com.kaldev.vereinsmanager.service;

import com.kaldev.vereinsmanager.entity.Responsible;
import com.kaldev.vereinsmanager.repository.ResponsibleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ResponsibleService {
    @Autowired
    private ResponsibleRepository responsibleRepository;

    public List<Responsible> listAllResponsible() {
        return responsibleRepository.findAll();
    }

    public void saveResponsible(Responsible responsible) {
        responsibleRepository.save(responsible);
    }

    public Responsible getResponsible(Integer id) {
        return responsibleRepository.findById(id).get();
    }

    public void deleteResponsible(Integer id) {
        responsibleRepository.deleteById(id);
    }
}
