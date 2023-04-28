package com.kaldev.vereinsmanager.entity;

import jakarta.persistence.*;

@Entity
public class SportsActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int responsibleID;

    public SportsActivity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResponsibleID() {
        return responsibleID;
    }

    public void setResponsibleID(int responsibleID) {
        this.responsibleID = responsibleID;
    }
}
