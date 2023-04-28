package com.kaldev.vereinsmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private int idOfGroup;
    private int idOfField;
    private int amountSegmentsOfField;
    private Date startTime;
    private Date endTime;

    public Booking() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdOfField() {
        return idOfField;
    }

    public void setIdOfField(int idOfField) {
        this.idOfField = idOfField;
    }

    public int getIdOfGroup() {
        return idOfGroup;
    }

    public void setIdOfGroup(int idOfGroup) {
        this.idOfGroup = idOfGroup;
    }

    public int getAmountSegmentsOfField() {
        return amountSegmentsOfField;
    }

    public void setAmountSegmentsOfField(int amountSegmentsOfField) {
        this.amountSegmentsOfField = amountSegmentsOfField;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
