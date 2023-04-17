package com.kaldev.vereinsmanager.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Jersey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sponsor;
    @ElementCollection
    private List<Integer> numbers;
    private int amountPants;
    private int amountSocks;
    private int groupID;
    private int year;

    public Jersey(Long id, String sponsor, List<Integer> numbers) {
        this.id = id;
        this.sponsor = sponsor;
        this.numbers = numbers;
    }

    public Jersey() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmountPants() {
        return amountPants;
    }

    public void setAmountPants(int amountPants) {
        this.amountPants = amountPants;
    }

    public int getAmountSocks() {
        return amountSocks;
    }

    public void setAmountSocks(int amountSocks) {
        this.amountSocks = amountSocks;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }
}
