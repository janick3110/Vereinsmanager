package com.kaldev.vereinsmanager.data.service;

import com.kaldev.vereinsmanager.data.entity.Roles;
import com.kaldev.vereinsmanager.data.repository.RolesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> listAllRoles() {
        return rolesRepository.findAll();
    }


    public void saveRole(Roles role) {
        rolesRepository.save(role);
    }

    public Roles getRole(Integer id) {
        return rolesRepository.findById(id).get();
    }

    public void deleteRole(Integer id) {
        rolesRepository.deleteById(id);
    }
}
